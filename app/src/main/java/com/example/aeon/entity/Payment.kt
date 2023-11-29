package com.example.aeon.entity

interface Payment {
    val id: Int
    val title: String?
    val amount: String?
    val created: Int?
}