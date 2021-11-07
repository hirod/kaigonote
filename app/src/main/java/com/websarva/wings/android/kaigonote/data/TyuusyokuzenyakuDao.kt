package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TyuusyokuzenyakuDao {
    @Query("SELECT * FROM tyuusyokuzenyaku")
    fun gettyuusyokuzenyakuAll(): List<Tyuusyokuzenyaku>

    @Insert
    fun insert(tyuusyokuzenyaku: Tyuusyokuzenyaku)

    @Delete
    fun delete(tyuusyokuzenyaku: Tyuusyokuzenyaku)
}