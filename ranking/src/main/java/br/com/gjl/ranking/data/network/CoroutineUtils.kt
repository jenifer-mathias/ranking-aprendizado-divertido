package br.com.gjl.ranking.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> executeIo(block: suspend () -> T): T {
    return withContext(Dispatchers.IO) {
        block()
    }
}
