package com.drmiaji.webviewtemplate.ui.dua

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.drmiaji.webviewtemplate.data.database.DuaDatabase
import com.drmiaji.webviewtemplate.data.model.DuaEntity
import kotlinx.coroutines.launch

class DuaListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ... your UI setup and dua list loading ...

        // Example: to open details for a selected dua
        fun showDuaDetail(duaId: Int) {
            lifecycleScope.launch {
                val dao = DuaDatabase.getInstance(applicationContext).duaDao()
                val dua: DuaEntity? = dao.getDuaById(duaId)
                dua?.let {
                    val intent = Intent(this@DuaListActivity, com.drmiaji.webviewtemplate.WebViewActivity::class.java)
                    intent.putExtra("dua_title", it.title)
                    intent.putExtra("dua_content", it.content)
                    startActivity(intent)
                }
            }
        }

        // Call showDuaDetail(someId) when user clicks a dua item
    }
}