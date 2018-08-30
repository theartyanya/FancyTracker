package com.example.darksher.fancytracker.domain

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Task() : RealmModel {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var text: String = ""
    var isDone: Boolean = true
    constructor(
            text: String,
            isDone: Boolean
    ) : this() {
        this.text = text
        this.isDone = isDone
    }
}