package ru.ivan.englishdictionary.utils.network

import android.content.Context
import android.net.ConnectivityManager


class NetworkUtil(private val context: Context) {
    fun isNetwrokConnected():Boolean {
        val nInfo = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        return nInfo != null && nInfo.isAvailable && nInfo.isConnected
    }
}