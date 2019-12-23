package org.bearmug.crawler.data

import java.time.Instant

data class RootRepository(
    val rootUrl: String,
    val projects: List<Project>)

data class Project(
    val key: String,
    val repos: List<Repo>)

data class Repo(
    val slug: String,
    val pullRequests: List<PullRequest>)

data class PullRequest(
    val id: Int,
    val creator: String,
    val state: PRState,
    val createdDate: Instant,
    val updatedDate: Instant,
    val changes: List<Change>) {
    enum class PRState { Merged }
}

data class Change(
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
    val mergeDate: Instant,
    val projectKey: String,
    val repoSlug: String,
    val rowsNumber: Int,
    val changeType: MetricChangeType,
    val fileType: String
)

enum class MetricChangeType { ADDED, REMOVED }