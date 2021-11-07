package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HaibenDao {
    @Query("SELECT * FROM haiben")
    fun gethainyouAll(): List<Haiben>

    @Insert
    fun insert(haiben: Haiben)

    @Delete
    fun delete(haiben: Haiben)
}