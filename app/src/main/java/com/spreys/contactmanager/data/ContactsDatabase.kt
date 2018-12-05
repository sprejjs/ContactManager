package com.spreys.contactmanager.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import java.util.concurrent.Executors

@Database(entities = [Contact::class], version = 1)
abstract class ContactsDatabase: RoomDatabase() {
    abstract fun contactsDao(): ContactDao

    companion object {
        private var INSTANCE: ContactsDatabase? = null
        fun getInstance(context: Context): ContactsDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            ContactsDatabase::class.java, "contacts.db")
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)

                                    Executors.newSingleThreadScheduledExecutor().execute {
                                        getInstance(context)?.contactsDao()?.insertAll(*MockDataGenerator.getMockContacts(50).toTypedArray())
                                    }
                                }
                            })
                            .build()
                }
            }
            return INSTANCE
        }
    }

}
