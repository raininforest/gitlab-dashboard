package com.github.raininforest.dashboard_user_mr.repository.remote.dto

data class Reviewer(
    val avatar_url: String,
    val id: Int,
    val name: String,
    val state: String,
    val username: String,
    val web_url: String
)