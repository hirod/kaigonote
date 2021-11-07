package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface YuusyokugoyakuDao {
    @Query("SELECT * FROM yuusyokugoyaku")
    fun getyuusyokugoyakuAll(): List<Yuusyokugoyaku>
    
    @Insert
    fun insert(yuusyokugoyaku: Yuusyokugoyaku)

    @Delete
    fun delete(yuusyokugoyaku: Yuusyokugoyaku)


}