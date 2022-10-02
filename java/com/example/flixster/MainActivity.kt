package com.example.flixster


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Lookup the RecyclerView in activity layout
        val itemListRv = findViewById<RecyclerView>(R.id.itemListRv)
        val button = findViewById<Button>(R.id.button)
        val name = findViewById<EditText>(R.id.nameInput)
        val link = findViewById<EditText>(R.id.itemLink)
        val price = findViewById<EditText>(R.id.priceInput)

        // Fetch the list of emails
        //emails = EmailFetcher.getItems()

        var data = ArrayList<ListItem>()

        // Create adapter passing in the list of emails
        var adapter = ListItemAdapter(data)

        button.setOnClickListener {
            fun View.hideKeyboard() {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(windowToken, 0)
            }
            data.add(ListItem(name.text.toString(), price.text.toString(), link.text.toString()))
            adapter = ListItemAdapter(data)
            // Attach the adapter to the RecyclerView to populate items
            itemListRv.adapter = adapter
            // Set layout manager to position the items
            itemListRv.layoutManager = LinearLayoutManager(this)
        }

    }
}