package com.example.cache

import com.example.register.RegisterReceiveRemote

data class TokenCache(
    val login: String,
    val token: String
)
object InMemoryCache {
    val useList: MutableList<RegisterReceiveRemote> = mutableListOf()
    val token: MutableList<TokenCache> = mutableListOf()
}