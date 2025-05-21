package com.drmiaji.webviewtemplate.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drmiaji.webviewtemplate.data.dao.DuaDao
import com.drmiaji.webviewtemplate.data.model.DuaEntity
import com.drmiaji.webviewtemplate.data.model.DuaGroupEntity

@Database(
    entities = [DuaEntity::class, DuaGroupEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DuaDatabase : RoomDatabase() {
    abstract fun duaDao(): DuaDao

    companion object {
        @Volatile
        private var INSTANCE: DuaDatabase? = null

        fun getInstance(context: Context): DuaDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DuaDatabase::class.java,
                "dua.db"
            )
                // To use a prepopulated database from assets:
                .createFromAsset("database/dua.db")
                .build()
    }
}