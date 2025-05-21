package com.drmiaji.webviewtemplate.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dua_group")
data class DuaGroupEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)