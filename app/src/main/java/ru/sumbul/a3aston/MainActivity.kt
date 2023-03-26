package ru.sumbul.a3aston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val countries: Array<String> = arrayOf(
        "Austria",
        "Colombia",
        "Madagascar",
        "Italy",
        "Thailand",
        "Poland",
        "Denmark",
        "Switzerland"
    )
    private val flags: Array<Int> = arrayOf(
        R.drawable.at,
        R.drawable.columbia,
        R.drawable.mg,
        R.drawable.it,
        R.drawable.th,
        R.drawable.pl,
        R.drawable.dk,
        R.drawable.swit,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.list_view)
        val manager = LinearLayoutManager(this)
        val adapter = MyAdapter(countries, flags)
        list.adapter = adapter
        list.layoutManager = manager


    }
}