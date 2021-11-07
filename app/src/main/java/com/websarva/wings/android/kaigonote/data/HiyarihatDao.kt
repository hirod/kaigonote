package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HiyarihatDao {
    @Query("SELECT * FROM hiyarihat")
    fun gethiyarihatAll(): List<Hiyarihat>

    @Insert
    fun insert(hiyarihat: Hiyarihat)

    @Delete
    fun delete(hiyarihat: Hiyarihat)
}