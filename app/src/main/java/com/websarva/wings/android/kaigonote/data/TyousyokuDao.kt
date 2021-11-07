package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TyousyokuDao {
    @Query("SELECT * FROM tyousyoku")
    fun gettyousyokuAll(): List<Tyousyoku>

    @Insert
    fun insert(tyousyoku: Tyousyoku)

    @Delete
    fun delete(tyousyoku: Tyousyoku)
}