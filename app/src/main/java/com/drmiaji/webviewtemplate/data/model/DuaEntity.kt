package com.drmiaji.webviewtemplate.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dua")
data class DuaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val groupId: Int
)