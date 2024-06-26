package com.example.gitsimpledemo.data.repository

import com.example.gitsimpledemo.AppConfig
import com.example.gitsimpledemo.data.network.api.ApiService
import com.example.gitsimpledemo.data.network.api.NetworkResult
import com.example.gitsimpledemo.data.network.api.callApiService
import com.example.gitsimpledemo.model.entity.UserEntity
import com.example.gitsimpledemo.model.entity.UserEntityList

/**
 * Author: Ryu
 * Date: 2024/05/23
 * Description: UserListRepository
 */
open class UserListRepository(private val apiService: ApiService) {
    private val pageSize = AppConfig.PAGE_SIZE

    suspend fun getData(since: Long): NetworkResult<UserEntityList> {
        return callApiService {
            apiService.listUsers(perPage = pageSize, since = since)
        }
    }

    suspend fun searchUsers(query: String, page: Int): NetworkResult<List<UserEntity>> {
        return callApiService {
            apiService.searchUsers(perPage = pageSize, query = query, page = page).items
        }
    }
}