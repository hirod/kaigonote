package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "koukuyoru")
data class Koukuyoru(
        @PrimaryKey(autoGenerate = true)
        var uid: Long,
        var hiduke: Date,
        var name: String,
        var koukuyoru: String,
)