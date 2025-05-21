package com.drmiaji.webviewtemplate.data.model

@Entity(tableName = "dua")
data class DuaEntity(
    @PrimaryKey val _id: Int,
    val ar_dua: String,
    val ar_reference: String?,
    val en_reference: String?,
    val en_translation: String,
    val fav: Int,
    val group_id: Int
)