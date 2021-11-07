package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NyuuyokukirokuDao {
    @Query("SELECT * FROM nyuuyokukiroku")
    fun getnyuuyokukirokuAll(): List<Nyuuyokukiroku>

    @Insert
    fun insert(nyuuyokukiroku: Nyuuyokukiroku)

    @Delete
    fun delete(nyuuyokukiroku: Nyuuyokukiroku)
    

}