package org.bearmug.crawler.data

import java.time.Instant

data class StashProjectsResponse(
    val isLastPage: Boolean,
    val values: List<StashProject>,
    val nextPageStart: Int) {
    data class StashProject(
        val key: String,
        val public: Boolean,
        val type: String)
}

data class StashReposResponse(
    val isLastPage: Boolean,
    val values: List<StashRepo>,
    val nextPageStart: Int) {
    data class StashRepo(val slug: String)
}

data class StashPullRequestsResponse(
    val isLastPage: Boolean,
    val values: List<StashPullRequest>,
    val nextPageStart: Int) {
    data class StashPullRequest(
        val id: Int,
        val state: String,
        val createdDate: Instant,
        val updatedDate: Instant,
        val author: PullRequestAuthor)
    data class PullRequestAuthor(val user: PullRequestUser)
    data class PullRequestUser(val emailAddress: String)
}

data class StashDiffResponse(val diffs: List<StashDiff>) {
    data class StashDiff(val hunks: List<DiffHunk>)
    data class DiffHunk(val segments: List<DiffSegment>)
    data class DiffSegment(val type: DiffSegmentType, val lines: List<DiffSegmentLine>)
    enum class DiffSegmentType { ADDED, REMOVED }
    data class DiffSegmentLine(val line: String)
}