package com.spreys.contactmanager.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity
data class Contact(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo var firstName: String?,
        @ColumnInfo var lastName: String?,
        @ColumnInfo var mobile: String?,
        @ColumnInfo var landline: String?) : Parcelable {

    fun name() = "$firstName $lastName"
    fun email() = "$firstName@spreys.com"

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id ?: -1)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(mobile)
        parcel.writeString(landline)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}
