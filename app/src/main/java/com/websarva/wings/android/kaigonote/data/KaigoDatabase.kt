package com.websarva.wings.android.kaigonote.data

import android.app.Application
import androidx.room.*
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}

@Database(entities = arrayOf(Resident::class, Kaigo::class), version = 1)

@TypeConverters(DateConverter::class)
abstract class KaigoDatabase : RoomDatabase() {
    abstract fun dao(): ResidentDao
    abstract fun kaigo(): KaigoDao
}

class KaigoDB {
    companion object {
        private const val DB_FILE = "kaigo.db"
        private var db: KaigoDatabase? = null
        fun getInstance(application: Application): KaigoDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                        application,
                        KaigoDatabase::class.java, DB_FILE).build()
            }
            return db!!
        }
    }
}

class hainyouDB {
    companion object {
        private const val DB_FILE = "hainyou.db"
        private val db: hainyouDatabase? = null
        fun getInstance(application: Application): hainyouDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                        application,
                        hainyouDatabase::class.java, DB_FILE.build()
            }
            return db!!
        }
    }
}

