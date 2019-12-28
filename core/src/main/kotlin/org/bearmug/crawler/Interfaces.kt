package org.bearmug.crawler

import arrow.core.Either
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobEvent
import org.bearmug.crawler.data.ImportJobId

typealias IssueDescription = String
interface ImportService {
    fun triggerProjectsImportJob(rootUrl: String): Either<IssueDescription, ImportJobId>
    fun cancelProjectsImport(id: ImportJobId): Either<IssueDescription, ImportJobId>
}

interface ImportJobRepo {
    fun submitJob(job: ImportJob): Either<IssueDescription, ImportJob>
    fun getJobDescription(id: ImportJobId): Either<IssueDescription, ImportJob>
    fun cancelJob(id: ImportJobId): Either<IssueDescription, ImportJob>
}

interface EventBus {
    fun publish(event: ImportJobEvent): Either<IssueDescription, Unit>
}