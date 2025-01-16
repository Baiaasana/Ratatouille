package com.example.ratatouille.presentation.search

data class SearchState(
    val isLoading: Boolean? = false,
    val error: String? = null
)