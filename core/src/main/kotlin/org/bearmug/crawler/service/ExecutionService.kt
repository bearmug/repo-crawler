package org.bearmug.crawler.service

import arrow.core.Either
import arrow.core.extensions.fx
import org.bearmug.crawler.ExecutionService
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.capabilities.import
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobId

class ExecutionServiceImpl(
    val repo: ImportJobRepo
) : ExecutionService {
    override fun import(id: ImportJobId): Either<IssueDescription, ImportJob> =
        Either.fx {
            val (job) = repo.findJob(id)
            val (importedJob) = job.import(repo)
            importedJob
        }

    override fun cancel(id: ImportJobId): Either<IssueDescription, ImportJob> =
        repo.cancelComplete(id)
}