package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NyuuyokuDao {
    @Query("SELECT * FROM nyuuyoku")
    fun getnyuuyokuAll(): List<Nyuuyoku>

    @Insert
    fun insert(nyuuyoku: Nyuuyoku)

    @Delete
    fun delete(nyuuyoku: Nyuuyoku)


}