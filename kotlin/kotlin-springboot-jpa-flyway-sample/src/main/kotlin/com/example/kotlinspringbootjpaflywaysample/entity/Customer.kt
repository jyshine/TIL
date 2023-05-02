package com.example.kotlinspringbootjpaflywaysample.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String? = null
    var email: String? = null

    constructor()

    constructor(name: String?, email: String?) {
        this.name = name
        this.email = email
    }

}