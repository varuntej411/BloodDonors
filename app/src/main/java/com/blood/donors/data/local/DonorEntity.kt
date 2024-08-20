package com.blood.donors.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "donors_table")
class DonorEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val age: Int,
    val town: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val email: String,
    val phoneNumber: String,
    val bloodGroup : String,
)
