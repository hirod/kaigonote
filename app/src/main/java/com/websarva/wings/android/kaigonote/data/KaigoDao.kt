package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KaigoDao {
    @Query("SELECT * FROM resident")
    fun getAll(): List<Resident>

    @Query("SELECT * FROM resident WHERE uid IN (:id)")
    fun findById(id: Int): Resident

    @Insert
    fun insert(resident: Resident)

    @Delete
    fun delete(resident: Resident)
}
