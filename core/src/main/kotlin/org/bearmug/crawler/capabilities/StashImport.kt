package org.bearmug.crawler.capabilities

import arrow.core.Either
import org.bearmug.crawler.ImportJobRepo
import org.bearmug.crawler.IssueDescription
import org.bearmug.crawler.data.ImportJob

fun ImportJob.import(repo: ImportJobRepo): Either<IssueDescription, ImportJob> = TODO()