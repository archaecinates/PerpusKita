package com.example.perpuskita.data

import com.example.perpuskita.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Data class for Book (you may modify this according to your actual data class)


class BookAdapter(private val listBooks: ArrayList<Book>) : RecyclerView.Adapter<BookAdapter.ListViewHolder>() {

    // Inner class ListViewHolder, which extends RecyclerView.ViewHolder
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Bind your views here, for example:
        val tvTitle: TextView = itemView.findViewById(R.id.title)

    }

    // Inflate the item layout and create the ViewHolder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_book, parent, false)
        return ListViewHolder(view)
    }

    // Bind data to views inside the ViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBooks[position]
        holder.tvTitle.text = book.JudulBuku
//        holder.tvAuthor.text = book.author
    }

    // Return the total number of items
    override fun getItemCount(): Int {
        return listBooks.size
    }
}
