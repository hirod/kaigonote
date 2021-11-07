package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MousiokuriDao {
    @Query("SELECT * FROM mousiokuri")
    fun getmousiokuriAll(): List<Mousiokuri>

    @Insert
    fun insert(mousiokuri: Mousiokuri)

    @Delete
    fun delete(mousiokuri: Mousiokuri)


}