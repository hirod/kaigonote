package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "nyuuyokukiroku")
data class Nyuuyokukiroku(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var hiduke: Date,
        var name: String,
        var ketuatu: String,
        var myakuhaku: String,
        var spo2: String,
)