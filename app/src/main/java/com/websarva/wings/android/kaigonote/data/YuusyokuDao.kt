package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface YuusyokuDao {
    @Query("SELECT * FROM yuusyoku")
    fun gettyuusyokuAll(): List<Yuusyoku>

    @Insert
    fun insert(yuusyoku: Yuusyoku)

    @Delete
    fun delete(yuusyoku: Yuusyoku)
}