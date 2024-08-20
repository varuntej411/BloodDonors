package com.blood.donors.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface DonorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDonors(entity: DonorEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAllDonors(entity: DonorEntity)

    @Delete
    suspend fun deleteDonors(entity: DonorEntity)

    @Query("Select * from donors_table")
    fun getAllDonors(): List<DonorEntity>

    @Query("select * from donors_table WHERE city = :city")
    fun getDonorsByCity(city: String): List<DonorEntity>

    @Query("SELECT * FROM donors_table WHERE state = :area")
    fun getDonorsByArea(area: String): List<DonorEntity>

    @Query("SELECT *  FROM donors_table ORDER BY city ASC")
    fun getProductsSortASC(): Flow<List<DonorEntity>>

    @Query("SELECT * FROM donors_table ORDER BY city DESC")
    fun getProductsSortDSC(): Flow<List<DonorEntity>>

    @Query("DELETE  FROM donors_table ")
    fun deleteAllDonorsList()
}
