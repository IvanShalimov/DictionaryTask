package ru.ivan.englishdictionary.utils.network

class NetworkConnectionException(val msg: String = "Отсуствует интернет соединение") :
    Exception(msg)