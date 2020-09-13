package ru.ivan.englishdictionary.network

class NetworkConnectionException(val msg:String = "Отсуствует интернет соединение"):Exception(msg)