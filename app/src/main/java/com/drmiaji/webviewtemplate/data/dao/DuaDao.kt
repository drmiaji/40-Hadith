package com.drmiaji.webviewtemplate.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.drmiaji.webviewtemplate.data.model.DuaEntity
import com.drmiaji.webviewtemplate.data.model.DuaGroupEntity

@Dao
interface DuaDao {
    // ----- DuaEntity methods -----
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDua(dua: DuaEntity)

    @Query("SELECT * FROM dua")
    suspend fun getAllDua(): List<DuaEntity>

    @Query("SELECT * FROM dua WHERE id = :id")
    suspend fun getDuaById(id: Int): DuaEntity?

    // ----- DuaGroupEntity methods -----
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: DuaGroupEntity)

    @Query("SELECT * FROM dua_group")
    suspend fun getAllGroups(): List<DuaGroupEntity>
}