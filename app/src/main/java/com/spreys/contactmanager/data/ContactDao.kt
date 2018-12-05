package com.spreys.contactmanager.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAll(): List<Contact>

    @Insert
    fun insertAll(vararg contacts: Contact)
}
