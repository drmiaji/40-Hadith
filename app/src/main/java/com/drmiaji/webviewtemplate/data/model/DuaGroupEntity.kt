package com.drmiaji.webviewtemplate.data.model

@Entity(tableName = "dua_group")
data class DuaGroupEntity(
    @PrimaryKey val _id: Int,
    val ar_title: String,
    val en_title: String,
    val fr_title: String?
)