package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KannsyokuDao {
    @Query("SELECT * FROM kannsyoku")
    fun getkannsyokuAll(): List<Kannsyoku>

    @Insert
    fun insert(kannsyoku: Kannsyoku)

    @Delete
    fun delete(kannsyoku: Kannsyoku)
}