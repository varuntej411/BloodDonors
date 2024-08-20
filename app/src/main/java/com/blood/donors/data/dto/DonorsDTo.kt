package com.blood.donors.data.dto

import com.blood.donors.data.local.DonorEntity
import com.blood.donors.domain.model.DonorModel
import java.util.Date

data class DonorsDTo(
    val id : Long,
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
    val medicationTime: Date,
    val endDate: Date
)

fun DonorsDTo.toDonorModel() : DonorModel {
    return DonorModel(
        id = id,
        name = name,
        age = age,
        town = town,
        city = city,
        state = state,
        postalCode = postalCode,
        country = country,
        email = email,
        phoneNumber = phoneNumber,
        bloodGroup = bloodGroup,
        medicationTime = medicationTime,
        endDate = endDate
    )
}

fun DonorsDTo.toDonorEntity() : DonorEntity {
    return DonorEntity(
        id = id,
        name = name,
        age = age,
        town = town,
        city = city,
        state = state,
        postalCode = postalCode,
        country = country,
        email = email,
        phoneNumber = phoneNumber,
        bloodGroup = bloodGroup
    )
}
