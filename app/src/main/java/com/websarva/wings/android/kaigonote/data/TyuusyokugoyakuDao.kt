package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TyuusyokugoyakuDao {
    @Query("SELECT * FROM tyuusyokugoyaku")
    fun gettyuusyokugoyakuAll(): List<Tyuusyokugoyaku>

    @Insert
    fun insert(tyuusyokugoyaku: Tyuusyokugoyaku)

    @Delete
    fun delete(tyuusyokugoyaku: Tyuusyokugoyaku)
}