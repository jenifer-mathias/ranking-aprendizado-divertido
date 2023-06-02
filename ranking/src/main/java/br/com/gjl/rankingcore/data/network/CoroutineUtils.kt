package br.com.gjl.rankingcore.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> executeIo(block: suspend () -> T): T {
    return withContext(Dispatchers.IO) {
        block()
    }
}
