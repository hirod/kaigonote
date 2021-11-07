package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ZikohoukokusyoDao {
    @Query("SELECT * FROM zikohoukokusyo")
    fun getzikohoukokusyoAll(): List<Zikohoukokusyo>

    @Insert
    fun insert(zikohoukokusyo: Zikohoukokusyo)

    @Delete
    fun delete(zikohoukokusyo: Zikohoukokusyo)
}