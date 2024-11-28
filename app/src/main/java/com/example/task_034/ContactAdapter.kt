package com.example.task_034

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val context: Context, private val listener: ContactClickListener):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    val contacts = ArrayList<Contact>()

    fun updateList(newList: List<Contact>) {
        contacts.clear()
        contacts.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        private val lastnameContactTV: TextView = itemView.findViewById(R.id.lastnameContactTV)
        private val phoneContactTV: TextView = itemView.findViewById(R.id.phoneContactTV)
        private val dataContactTV: TextView = itemView.findViewById(R.id.dataContactTV)
        val itemIconDeleteIV: ImageView = itemView.findViewById(R.id.itemIconDeleteIV)

        fun bind(contact: Contact) {
            lastnameContactTV.text = contact.lastname
            phoneContactTV.text = contact.phone
            dataContactTV.text = contact.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val viewHolder = ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
        viewHolder.itemIconDeleteIV.setOnClickListener{
            listener.onItemClicked(contacts[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = contacts[position]
        holder.bind(currentContact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    interface ContactClickListener {
        fun onItemClicked(contact: Contact)
    }
}