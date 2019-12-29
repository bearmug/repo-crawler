package org.bearmug.crawler.service

import arrow.core.Either
import arrow.core.extensions.fx
import org.bearmug.crawler.EventBus
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.CommandService
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.capabilities.resolveUrl
import org.bearmug.crawler.capabilities.toCommand
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJob.JobType
import org.bearmug.crawler.data.ImportJobId
import java.util.*

class CommandServiceImpl(
    val repo: ImportJobRepo,
    val bus: EventBus
) : CommandService {
    override fun commandImportJob(rootUrl: String, type: JobType): Either<IssueDescription, ImportJobId> =
        Either.fx {
            val newJob = ImportJob(id = UUID.randomUUID(), type = type).resolveUrl(rootUrl)
            val (job) = repo.create(newJob)
            val (_) = bus.publish(job.toCommand())
            job.id
        }

    override fun commandCancelJob(id: ImportJobId): Either<IssueDescription, ImportJobId> =
        Either.fx {
            val (job) = repo.cancelRequested(id)
            val (_) = bus.publish(job.toCommand())
            job.id
        }
}