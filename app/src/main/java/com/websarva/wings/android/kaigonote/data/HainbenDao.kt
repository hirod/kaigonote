package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.*

@Dao
interface HaibenDao {
    @Query("SELECT * FROM haiben LIMIT 100 OFFSET 0")
    fun gethaibenAll(): List<Haiben>

    @Query("SELECT * FROM haiben WHERE hiduke =:hiduke LIMIT 100 OFFSET 0")
    fun gethaibenByhiduke(hiduke: Date): List<Haiben>

    @Insert
    fun insert(haiben: Haiben)

    @Delete
    fun delete(haiben: Haiben)
}