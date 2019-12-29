package org.bearmug.crawler

import arrow.core.Either
import org.bearmug.crawler.data.ImportCommand
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJob.JobType
import org.bearmug.crawler.data.ImportJobEvent
import org.bearmug.crawler.data.ImportJobId

typealias IssueDescription = String
interface CommandService {
    fun commandImportJob(rootUrl: String, type: JobType): Either<IssueDescription, ImportJobId>
    fun commandCancelJob(id: ImportJobId): Either<IssueDescription, ImportJobId>
}

interface ExecutionService {
    fun import(id: ImportJobId): Either<IssueDescription, ImportJob>
    fun cancel(id: ImportJobId): Either<IssueDescription, ImportJob>
}

interface ImportJobRepo {
    fun submitJob(job: ImportJob): Either<IssueDescription, ImportJob>
    fun findJob(id: ImportJobId): Either<IssueDescription, ImportJob>
    fun cancelJob(id: ImportJobId): Either<IssueDescription, ImportJob>
}

interface EventBus {
    fun publish(event: ImportJobEvent): Either<IssueDescription, Unit>
    fun publish(command: ImportCommand): Either<IssueDescription, Unit>
}