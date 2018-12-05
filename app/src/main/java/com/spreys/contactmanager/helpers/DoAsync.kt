package com.spreys.contactmanager.helpers

import android.os.AsyncTask

class DoAsync<T>(val handler: () -> T, val callBack: (T) -> Unit) : AsyncTask<Void, Void, T>() {
    init {
        execute()
    }

    override fun doInBackground(vararg params: Void?): T {
        return handler()
    }

    override fun onPostExecute(result: T) {
        super.onPostExecute(result)
        callBack(result)
    }
}