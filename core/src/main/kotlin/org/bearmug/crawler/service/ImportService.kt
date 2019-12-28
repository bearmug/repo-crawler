package org.bearmug.crawler.service

import arrow.core.Either
import arrow.core.extensions.fx
import org.bearmug.crawler.EventBus
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.ImportService
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.capabilities.resolveUrl
import org.bearmug.crawler.capabilities.toCancelledEvent
import org.bearmug.crawler.capabilities.toNewEvent
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJob.JobType.ProjectsImport
import org.bearmug.crawler.data.ImportJobId
import java.util.*

class ImportServiceImpl(
    val repo: ImportJobRepo,
    val bus: EventBus
) : ImportService {
    override fun triggerProjectsImportJob(rootUrl: String): Either<IssueDescription, ImportJobId> =
        Either.fx {
            val newJob = ImportJob(id = UUID.randomUUID(), type = ProjectsImport).resolveUrl(rootUrl)
            val (job) = repo.submitJob(newJob)
            val (_) = bus.publish(job.toNewEvent())
            job.id
        }

    override fun cancelProjectsImport(id: ImportJobId): Either<IssueDescription, ImportJobId> =
        Either.fx {
            val (cancelledJob) = repo.cancelJob(id)
            val (_) = bus.publish(cancelledJob.toCancelledEvent())
            cancelledJob.id
        }
}