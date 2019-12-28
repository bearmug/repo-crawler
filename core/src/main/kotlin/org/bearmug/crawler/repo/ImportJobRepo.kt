package org.bearmug.crawler.repo

import arrow.core.Either
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobId

class ImportJobRepoImpl : ImportJobRepo {
    override fun submitJob(job: ImportJob): Either<IssueDescription, ImportJob> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJobDescription(id: ImportJobId): Either<IssueDescription, ImportJob> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelJob(id: ImportJobId): Either<IssueDescription, ImportJob> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}