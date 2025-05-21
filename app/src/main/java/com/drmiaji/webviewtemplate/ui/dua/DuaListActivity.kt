package com.drmiaji.webviewtemplate.ui.dua

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.drmiaji.webviewtemplate.data.database.DuaDatabase
import kotlinx.coroutines.launch

class DuaListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = DuaDatabase.getInstance(this)
        val duaDao = db.duaDao()

        lifecycleScope.launch {
            val allDuas = duaDao.getAllDua()
            // TODO: Display the list
        }
    }
}