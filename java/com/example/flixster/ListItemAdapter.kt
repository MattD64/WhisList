package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListItemAdapter(private val Items: List<ListItem>) : RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // TODO: Store each of the layout's views into
        // the public final member variables created above
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            senderTextView = itemView.findViewById(R.id.itemName)
            titleTextView = itemView.findViewById(R.id.itemPrice)
            summaryTextView = itemView.findViewById(R.id.itemUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val view = inflater.inflate(R.layout.item, parent, false)
        // Return a new holder instance
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val email = Items.get(position)
        // Set item views based on views and data model
        holder.senderTextView.text = email.name
        holder.titleTextView.text = email.price
        holder.summaryTextView.text = email.url
    }


    override fun getItemCount(): Int {
        return Items.size
    }
}