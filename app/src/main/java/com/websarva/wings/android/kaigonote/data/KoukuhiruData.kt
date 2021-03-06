package com.websarva.wings.android.kaigonote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "koukuhiru")
data class Koukuhiru(
    @PrimaryKey(autoGenerate = true)
    var uid: Long,
    var hiduke: Date,
    var name: String,
    var koukuhiru: String,
    var bikou: String
) : BaseKoukuData()