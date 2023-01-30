package com.km.viewcomposebenchmark

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalView
import com.km.viewcomposebenchmark.ui.compose.fragment.ComposeFragment
import com.km.viewcomposebenchmark.ui.compose.fragment.ListItems
import com.km.viewcomposebenchmark.ui.view.ViewFragment

class MainActivity : AppCompatActivity() {

    private var onCreateTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreateTime = System.currentTimeMillis()
        Log.i("dbgkm", "composeActivity onCreate $onCreateTime")

        // Compose Only
//        setContent {
//            ListItems()
//
//            val view = LocalView.current
//            view.viewTreeObserver.addOnDrawListener {
//                val onDrawTime = System.currentTimeMillis()
//                Log.i("dbgkm", "composeActivity onDraw ${onDrawTime - onCreateTime}")
//            }
//        }

        // Compose or View within XML
        setContentView(R.layout.activity_container_xml)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ComposeFragment::class.java, null)
            .commit()
    }

    override fun onResume() {
        super.onResume()
        val onResumeTime = System.currentTimeMillis()
        Log.i("dbgkm", "composeActivity onResume ${onResumeTime - onCreateTime}")
    }
}