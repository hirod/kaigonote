package com.websarva.wings.android.kaigonote.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "resident")
data class Resident(
    @PrimaryKey(autoGenerate = true)
    val uid: Long,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "date")
    val birthday: Date
)
