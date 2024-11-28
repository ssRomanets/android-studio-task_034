package com.example.task_034

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contact(
    @ColumnInfo(name="lastname") var lastname: String,
    @ColumnInfo(name="phone")    var phone: String,
    @ColumnInfo(name="data")     var data: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
