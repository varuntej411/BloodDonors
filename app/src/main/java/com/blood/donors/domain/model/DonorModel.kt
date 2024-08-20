package com.blood.donors.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class DonorModel(
    val id: Long,
    val name: String,
    val age: Int,
    val town: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String,
    val email: String,
    val phoneNumber: String,
    val bloodGroup: String,
    val medicationTime: Date,
    val endDate: Date
) : Parcelable