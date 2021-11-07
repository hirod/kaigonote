package com.websarva.wings.android.kaigonote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KoukuhiruDao {
    @Query("SELECT * FROM koukuhiru")
    fun getkoukuhiruAll(): List<Koukuhiru>

    @Insert
    fun insert(koukuhiru: Koukuhiru)

    @Delete
    fun delete(koukuhiru: Koukuhiru)
}