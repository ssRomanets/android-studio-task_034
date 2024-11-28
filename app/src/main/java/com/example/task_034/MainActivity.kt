package com.example.task_034

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.system.exitProcess
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity(), ContactAdapter.ContactClickListener {

    private lateinit var viewModal: ContactViewModal
    private lateinit var lastnameET: EditText
    private lateinit var phoneET: EditText
    private lateinit var recyclerVewRV: RecyclerView

    private lateinit var toolbarMain: Toolbar

    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setSupportActionBar(toolbarMain)
        title = "Данные о пользователе."

        recyclerVewRV.layoutManager = LinearLayoutManager(this)
        val adapter = ContactAdapter(this, this)
        recyclerVewRV.adapter = adapter

        viewModal = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(application))[ContactViewModal::class.java]
        viewModal.contacts.observe(this, {list ->
            list?.let{
                adapter.updateList(it)
            }
        })
    }

    private fun init() {
        toolbarMain = findViewById(R.id.toolbarMain)
        lastnameET = findViewById(R.id.lastnameET)
        phoneET = findViewById(R.id.phoneET)
        recyclerVewRV = findViewById(R.id.recyclerViewRV)
    }

    override fun onItemClicked(contact: Contact) {
        viewModal.deleteContact(contact)
        Toast.makeText(this, "${contact.lastname}, ${contact.phone} удален", Toast.LENGTH_LONG).show()
    }

    fun saveData(view: View) {
        val lastname = lastnameET.text.toString()
        val phone = phoneET.text.toString()
        val timestamp =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")).toString()

        if (lastname.isNotEmpty() && phone.isNotEmpty()) {
            viewModal.insertContact(Contact(lastname, phone, timestamp))
            Toast.makeText(this, "$lastname, $phone, $timestamp сохранены", Toast.LENGTH_LONG).show()
        }
        lastnameET.text.clear()
        phoneET.text.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuMain->{
                moveTaskToBack(true);
                exitProcess(-1)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}