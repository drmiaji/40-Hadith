package com.drmiaji.webviewtemplate.data.database

import android.content.Context
import com.drmiaji.webviewtemplate.data.dao.DuaDao
import com.drmiaji.webviewtemplate.data.model.DuaEntity
import com.drmiaji.webviewtemplate.data.model.DuaGroupEntity

@Database(entities = [DuaEntity::class, DuaGroupEntity::class], version = 1)
abstract class DuaDatabase : RoomDatabase() {
    abstract fun duaDao(): DuaDao

    companion object {
        @Volatile private var instance: DuaDatabase? = null

        fun getDatabase(context: Context): DuaDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    DuaDatabase::class.java,
                    "dua.db"
                ).createFromAsset("database/dua.db") // you’ll put your file in assets/database/
                    .build().also { instance = it }
            }
        }
    }
}
