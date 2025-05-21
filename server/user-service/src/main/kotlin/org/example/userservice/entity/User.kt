package org.example.userservice.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var username: String? = null
    var password: String? = null
    var email: String? = null

    constructor()

    constructor(username: String, password: String, email: String) {
        this.username = username
        this.password = password
        this.email = email
    }
}

