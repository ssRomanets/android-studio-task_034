package com.example.task_034

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModal(application: Application): AndroidViewModel(application) {
    private val repository: ContactRepository
    val contacts: LiveData<List<Contact>>

    init{
        val dao = ContactDatabase.getDatabase(application).getContactDao()
        repository = ContactRepository(dao)
        contacts = repository.notes
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(contact)
    }

    fun insertContact(contact: Contact) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(contact)
    }
}