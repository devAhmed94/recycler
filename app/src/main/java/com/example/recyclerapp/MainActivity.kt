package com.example.recyclerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val myAdapter by lazy { MyAdapter() }
    private val list: ArrayList<PostModel> by lazy { ArrayList<PostModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rvMain = findViewById<RecyclerView>(R.id.rvMain)
        for (i in 1..100) {
            list.add(
                PostModel(
                    "ahmed",
                    "https://media.gettyimages.com/photos/camel-and-the-pyramids-in-giza-picture-id1139238705?s=2048x2048"
                )
            )
        }

        rvMain.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            myAdapter.setList(list)
            adapter = myAdapter
            myAdapter.setListener(object : OnClickItemRecycler {
                override fun onClickItem(postModel: PostModel) {
                    Toast.makeText(this@MainActivity, postModel.name, Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}