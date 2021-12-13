package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "koukuasa")
data class Koukuasa(
    @PrimaryKey(autoGenerate = true)
    var uid: Long,
    var hiduke: Date,
    var name: String,
    var koukuasa: String,
    var bikou: String
) : BaseKoukuData()