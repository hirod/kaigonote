package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TyuusyokuDao {
    @Query("SELECT * FROM tyuusyoku")
    fun gettyuusyokuAll(): List<Tyuusyoku>

    @Insert
    fun insert(tyuusyoku: Tyuusyoku)

    @Delete
    fun delete(tyuusyoku: Tyuusyoku)
}