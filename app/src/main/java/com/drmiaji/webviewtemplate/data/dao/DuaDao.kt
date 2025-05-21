package com.drmiaji.webviewtemplate.data.dao

import com.drmiaji.webviewtemplate.data.model.DuaEntity

@Dao
interface DuaDao {
    @Query("SELECT * FROM dua ORDER BY _id ASC")
    suspend fun getAllDuas(): List<DuaEntity>

    @Query("SELECT * FROM dua WHERE group_id = :groupId")
    suspend fun getDuasByGroup(groupId: Int): List<DuaEntity>
}