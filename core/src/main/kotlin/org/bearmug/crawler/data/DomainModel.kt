package org.bearmug.crawler.data

import arrow.core.Option
import java.time.Instant
import java.util.*

typealias ImportJobId = UUID
data class ImportJob(
    val id: ImportJobId,
    val status: JobStatus = JobStatus.New,
    val type: JobType,
    val updatedAt: Option<Instant> = Option.empty(),
    val createdAt: Option<Instant> = Option.empty(),
    val itemsProcessed: Int = 0,
    val itemsTotal: Option<Int> = Option.empty(),
    val importUrl: String = "",
    val nestedUrls: List<String> = listOf()) {

    enum class JobStatus { New, Wip, Finished, Cancelled }
    enum class JobType { ProjectsImport, ReposImport, PullRequestsImport }
}

data class ImportJobEvent(
    val id: ImportJobId,
    val type: EventType,
    val eventTimetamp: Instant,
    val itemsProcessed: Int,
    val itemsTotal: Option<Int>,
    val processedDelta: Int,
    val failedDelta: Int) {

    enum class EventType { JobSubmitted, ImportUpdate, JobCancelled, JobFinished }
}

data class ImportCommand(
    val id: ImportJobId,
    val type: CommandType) {

    enum class CommandType { Import, Cancel }
}

data class StashPullRequest(
    val id: Int,
    val creator: String,
    val state: PRState,
    val createdDate: Instant,
    val updatedDate: Instant,
    val changes: List<StashChange>) {

    enum class PRState { Merged }
}

data class StashChange(
    val fileName: String,
    val fileExtension: String,
    val rowsAdded: Int,
    val rowsRemoved: Int)

data class MetricPullRequest(
    val creator: String,
    val mergeDate: Instant,
    val reviewDurationMinutes: Int,
    val projectKey: String,
    val repoSlug: String,
    val rowsNumber: Int,
    val changeType: MetricChangeType
)
data class MetricCodeChange(
    val creator: String,
    val date: Instant,
    val projectKey: String,
    val repoSlug: String,
    val rowsNumber: Int,
    val changeType: MetricChangeType,
    val fileType: String
)

enum class MetricChangeType { Added, Removed }