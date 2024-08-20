package com.blood.donors.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

// when need to migrate data base use below code
// @Database(entities = [FoodAppEntity::class], version = 1, autoMigrations = [
// AutoMigrationSpec(from = 1, to = 2, spec = FoodStoreDataBase.AutoMigration::class)])
// need type converters use below one
// @TypeConverters(FoodNameTypeConverter::class)

@Database(entities = [DonorEntity::class], version = 1)
abstract class DonorRoomDataBase : RoomDatabase() {

    abstract fun getDonorsDAO(): DonorDAO
}

//    put these lines above if need
//    @DeleteColumn(tableName = "DonorEntity", columnName = "timesOfDay")
//    @RenameColumn(tableName = "MedicationEntity", fromColumnName = "date", toColumnName = "medicationTime")
//    class AutoMigration : AutoMigrationSpec

//when callback needs use this below code
/*class Callback @Inject constructor(
    private val database: Provider<FoodStoreDataBase>,
    @ApplicationScope private val applicationScope: CoroutineScope
) : RoomDatabase.Callback()*/
