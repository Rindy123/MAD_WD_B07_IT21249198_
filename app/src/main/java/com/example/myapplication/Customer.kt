package com.example.myapplication

class Customer(toString: String, toString1: String, toString2: String, toString3: String) {
    private var UserName: String? = null
    private var Tel: String? = null
    private var Address: String? = null
    private var Password: String? = null
    fun Customer(userName: String, tel: String, address: String, password: String) {
        UserName = userName
        Tel = tel
        Address = address
        Password = password
    }

    fun Customer() {}


    fun getUserName(): String? {
        return UserName
    }

    fun setUserName(userName: String) {
        UserName = userName
    }

    fun getTel(): String? {
        return Tel
    }

    fun setTel(tel: String) {
        Tel = tel
    }

    fun getAddress(): String? {
        return Address
    }

    fun setAddress(address: String) {
        Address = address
    }

    fun getPassword(): String? {
        return Password
    }

    fun setPassword(password: String) {
        Password = password
    }
}
