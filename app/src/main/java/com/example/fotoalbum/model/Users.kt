package com.example.fotoalbum.model

data class Users ()
{
    var id: Int = 0
    var name: String = ""
    var username: String = ""
    var email: String = ""
    var address: Address = Address()
    var phone: String = ""
    var website: String = ""
    var company: Company = Company()
}


