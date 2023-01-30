package com.km.viewcomposebenchmark.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.km.viewcomposebenchmark.R

class ViewFragment: Fragment() {

    private var onCreateTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateTime = System.currentTimeMillis()
        Log.i("dbgkm", "viewFragment onCreate $onCreateTime")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ContentAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        view.viewTreeObserver.addOnDrawListener {
            val onDrawTime = System.currentTimeMillis()
            Log.i("dbgkm", "viewFragment onDraw ${onDrawTime - onCreateTime}")
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val onResumeTime = System.currentTimeMillis()
        Log.i("dbgkm", "viewFragment onResume ${onResumeTime - onCreateTime}")
    }
}