package org.example.userservice.entity

import jakarta.persistence.*

@Entity
@Table(name = "tokens")
class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var userId: Long? = null
    var token: String? = null

    constructor()

    constructor(userId: Long, token: String) {
        this.userId = userId
        this.token = token
    }
}