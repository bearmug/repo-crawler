package org.bearmug.crawler.capabilities

import org.bearmug.crawler.data.ImportJob

fun ImportJob.resolveUrl(url: String): ImportJob {
    val suffix: String = when (this.type) {
        ImportJob.JobType.ProjectsImport -> "/rest/api/1.0/projects"
        ImportJob.JobType.ReposImport -> "/repos"
        ImportJob.JobType.PullRequestsImport -> "/pull-requests"
    }
    return this.copy(importUrl = "$url$suffix")
}