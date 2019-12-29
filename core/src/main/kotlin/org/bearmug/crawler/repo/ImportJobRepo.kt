package org.bearmug.crawler.repo

import arrow.core.Either
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobId

abstract class ImportJobRepoImpl : ImportJobRepo {
    override fun findJob(id: ImportJobId): Either<IssueDescription, ImportJob> {
        TODO("not implemented")
    }

    override fun create(job: ImportJob): Either<IssueDescription, ImportJob> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelRequested(id: ImportJobId): Either<IssueDescription, ImportJob> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelComplete(id: ImportJobId): Either<IssueDescription, ImportJob> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}