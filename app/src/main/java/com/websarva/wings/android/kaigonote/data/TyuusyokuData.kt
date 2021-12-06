package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tyuusyoku")
data class Tyuusyoku(
    @PrimaryKey(autoGenerate = true)
    var uid: Long,
    var hiduke: Date,
    var name: String,
    var tyuusyoku: String,
    var fukusyoku: String,
    var tyuusyokuInsui: String
) : BaseSyokujiData()