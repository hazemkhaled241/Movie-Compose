package com.hazem.movie_app.data.paging

import retrofit2.Response

class PaginationFactory<Key, Item>
    (
    private val initialKey: Key,
    private inline val onLoading: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextPage: Key) -> Response<Item>,
    private inline val onSuccess: suspend (items: Item, newPage: Key) -> Unit,
    private inline val onError: suspend (Throwable?) -> Unit,
    private inline val getNextKey: suspend (Item) -> Key
) : Pagination<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextPage() {
        if (isMakingRequest)
            return

        isMakingRequest = true
        onLoading(true)

        try {
            val response = onRequest(currentKey)
            if (response.isSuccessful)
                isMakingRequest = false
            val items = response.body()!!
            currentKey = getNextKey(items)!!
            onSuccess(items, currentKey)
            onLoading(false)
        } catch (e: Exception) {
            onError(e)
            onLoading(false)
        }
    }

    override fun reset() {
        currentKey = initialKey
    }

}