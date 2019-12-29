package org.bearmug.crawler.service

import arrow.core.Either
import arrow.core.extensions.fx
import org.bearmug.crawler.EventBus
import org.bearmug.crawler.ExecutionService
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.capabilities.import
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJob.JobStatus.New
import org.bearmug.crawler.data.ImportJobId

class ExecutionServiceImpl(
    val repo: ImportJobRepo
) : ExecutionService {
    override fun import(id: ImportJobId): Either<IssueDescription, ImportJob> =
        Either.fx {
            val (job) = repo.findJob(id)
            val (decision) = if (job.status == New)
                Either.right(job) else
                Either.left("Obsolete job status ${job.status}")
            decision.import(repo)
        }

    override fun cancel(id: ImportJobId): Either<IssueDescription, ImportJob> =
        Either.fx {
            // TODO interrupt ongoing job
            val (cancelledJob) = repo.cancelJob(id)
            cancelledJob
    }
}