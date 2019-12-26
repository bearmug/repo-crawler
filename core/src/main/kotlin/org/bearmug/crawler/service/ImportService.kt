package org.bearmug.crawler.service

import arrow.core.Either
import arrow.core.Option
import arrow.core.flatMap
import org.bearmug.crawler.EventBus
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.ImportService
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobEvent
import org.bearmug.crawler.data.ImportJobId



class ImportServiceImpl(
    val repo: ImportJobRepo,
    val bus: EventBus
) : ImportService {
    override fun triggerProjectsImportJob(rootUrl: String): Either<IssueDescription, ImportJobId> {
        val job = ImportJob(
            type = ImportJob.JobType.ProjectsImport
        ).composeUrl(rootUrl)
        repo.submitNewJob(job)
            .flatMap { j ->
                bus.publish(ImportJobEvent(
                    j.id.,
                    ImportJobEvent.EventType.JobSubmitted,
                    job.createdAt,
                    0,
                    Option.empty(),
                    0, 0)).flatMap { Either.right(job.id) }
            }
    }

    override fun cancelProjectsImport(rootUrl: String): Either<IssueDescription, ImportJobId> {
        TODO("not implemented")
    }
}