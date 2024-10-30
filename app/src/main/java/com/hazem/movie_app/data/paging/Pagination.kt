package com.hazem.movie_app.data.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}