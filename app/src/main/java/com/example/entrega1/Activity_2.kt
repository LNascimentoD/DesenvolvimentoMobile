package com.example.entrega1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.entrega1.adapters.ViewPageAdapter
import com.example.entrega1.fragment.fragment_lojas
import com.example.entrega1.fragment.fragment_produtos
import com.google.android.material.tabs.TabLayout

class Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        mountTabs()
        mountListView()
    }

    private fun mountTabs() {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(fragment_lojas(), "Lojas")
        adapter.addFragment(fragment_produtos(), "Produtos")

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun mountListView(){
        val arrayAdapter: ArrayAdapter<*>
        val items: Array<String> = arrayOf(
            "O nome do vento",
            "50 tons de cinza",
            "O menino do pijama listrado",
            "Diário de um banana",
            "Bíblia",
            "Drácula"
        )

        var listView: ListView = findViewById(R.id.listView)
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, items)

        listView.adapter = arrayAdapter
    }
}