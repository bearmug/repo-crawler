package org.bearmug.crawler.capabilities

import org.bearmug.crawler.data.ImportCommand
import org.bearmug.crawler.data.ImportJob
import org.bearmug.crawler.data.ImportJobEvent

fun ImportJob.toNewEvent(): ImportJobEvent = TODO()
fun ImportJob.toCancelledEvent(): ImportJobEvent = TODO()
fun ImportJob.toCommand(): ImportCommand = TODO()