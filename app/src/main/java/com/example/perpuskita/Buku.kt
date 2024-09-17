package com.example.perpuskita

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perpuskita.data.Book
import com.example.perpuskita.data.BookAdapter
import com.example.perpuskita.databinding.ActivityBukuBinding

class Buku : AppCompatActivity() {
    private lateinit var binding: ActivityBukuBinding

    var buku1=Book(1,"ll", "Laut Bercerita", "Leila S. Chudori","12-08-2024","18-08-2024")
    var buku2=Book(2,"kk", "Bumi Manusia","Pram","13-08-2024","20-08-2024")
    var buku3=Book(3,"jj", "Mm", "Leila","12-08-2024","18-08-2024")
    var buku4=Book(4,"kj", "Ml", "Leila","12-08-2024","18-08-2024")
    var buku5=Book(5,"oo", "lm", "Leila","12-08-2024","18-08-2024")

    var bookList: ArrayList<Book> = arrayListOf(buku1,buku2,buku3,buku4,buku5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding
        binding = ActivityBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ShowTransaction()
    }

    fun ShowTransaction(){
        binding.rvBooks.layoutManager= LinearLayoutManager(this)
        val BookAdapter=BookAdapter(bookList)
        binding.rvBooks.adapter=BookAdapter
    }
}
