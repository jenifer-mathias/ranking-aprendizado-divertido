package br.com.gjl.ranking.data.network

sealed class Output<out T> {
    data class Success<out T>(val data: T) : Output<T>()
    data class Error(val code: Int, val message: String) : Output<Nothing>()
}
