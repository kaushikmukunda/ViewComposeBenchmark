package com.km.viewcomposebenchmark.ui.compose.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.km.viewcomposebenchmark.R
import com.km.viewcomposebenchmark.api.Items
import com.km.viewcomposebenchmark.api.RowModel

class ComposeFragment : Fragment() {

    private var onCreateTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateTime = System.currentTimeMillis()
        Log.i("dbgkm", "composeFragment onCreate $onCreateTime")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compose, container, false)

        view.findViewById<ComposeView>(R.id.compose_view).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ListItems()
            }
        }

        view.viewTreeObserver.addOnDrawListener {
            val onDrawTime = System.currentTimeMillis()
            Log.i("dbgkm", "composeFragment onDraw ${onDrawTime - onCreateTime}")
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        val onResumeTime = System.currentTimeMillis()
        Log.i("dbgkm", "composeFragment onResume ${onResumeTime - onCreateTime}")
    }
}

@Composable
fun ListItems() {
    LazyColumn {
        items(count = Items.ROW_MODELS.size) { idx ->
            ItemRow(Items.ROW_MODELS[idx])
        }
    }

}

@Composable
private fun ItemRow(model: RowModel) {
    Row {
        Image(
            painter = painterResource(id = model.imgRes),
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        )

        Text(
            text = model.text,
            modifier = Modifier.padding(start = 8.dp, top = 24.dp)
        )
    }
}