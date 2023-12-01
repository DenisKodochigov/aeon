package com.example.aeon.entity

object Authorization: User {
    override var login: String = ""
    override var password: String = ""
    var token: String = ""

    fun clear(){
        login = ""
        password = ""
        token = ""
    }
    fun set(login: String? = null , password: String? = null , token: String? = null ){
        login?.let { this.login = it }
        password?.let { this.password = it }
        token?.let { this.token = it }
    }
}
