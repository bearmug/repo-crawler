package org.bearmug.crawler.capabilities

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobEvent

fun ImportJob.import(): Either<IssueDescription, Flow<ImportJobEvent>> = TODO()