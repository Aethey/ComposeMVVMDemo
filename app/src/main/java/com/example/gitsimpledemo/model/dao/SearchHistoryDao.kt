package com.example.gitsimpledemo.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.gitsimpledemo.model.entity.SearchHistoryEntity

/**
 * Author: Ryu
 * Date: 2024/05/24
 * Description: control SearchHistory data
 */

@Dao
interface SearchHistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(searchHistoryEntity: SearchHistoryEntity): Long

    @Query("SELECT * FROM search_history ORDER BY timestamp DESC")
    suspend fun getAllHistorySortedByTime(): List<SearchHistoryEntity>

    @Query("SELECT * FROM search_history WHERE search_query = :query LIMIT 1")
    suspend fun getHistoryByQuery(query: String): SearchHistoryEntity?

    @Query("SELECT * FROM search_history WHERE search_query LIKE '%' || :query || '%' ORDER BY timestamp DESC")
    suspend fun getAllHistoryContainingQuery(query: String): List<SearchHistoryEntity>

    @Query("DELETE FROM search_history")
    suspend fun clearSearchHistory()

    @Update
    suspend fun update(searchHistoryEntity: SearchHistoryEntity)

    @Transaction
    suspend fun upsert(searchHistoryEntity: SearchHistoryEntity) {
        if (searchHistoryEntity.searchQuery.isBlank()) {
            // Skip insert or update if the search query is null, empty, or blank
            return
        }

        val existingEntity = getHistoryByQuery(searchHistoryEntity.searchQuery)
        if (existingEntity == null) {
            insert(searchHistoryEntity)
        } else {
            // Update the timestamp or any other fields if needed
            update(searchHistoryEntity.copy(id = existingEntity.id))
        }
    }
}