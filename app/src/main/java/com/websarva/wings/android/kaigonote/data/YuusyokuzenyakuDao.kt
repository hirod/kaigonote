package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface YuusyokuzenyakuDao {
    @Query("SELECT * FROM yuusyokuzenyaku")
    fun getyuusyokuzenyakuAll(): List<Yuusyokuzenyaku>

    @Insert
    fun insert(yuusyokuzenyaku: Yuusyokuzenyaku)

    @Delete
    fun delete(yuusyokuzenyaku: Yuusyokuzenyaku)
}