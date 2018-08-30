package com.example.darksher.fancytracker.domain

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Note() : RealmModel {
    @PrimaryKey
    var id: String = UUID.randomUUID().toString()
    var date: Long = 0L
    var title: String? = null
    var tasks: RealmList<Task> = RealmList()
    var isDone: Boolean = false

    constructor(
            date: Long,
            title: String?,
            tasks: List<Task>,
            isDone: Boolean
    ) : this() {
        this.date = date
        this.title = title
        this.tasks.addAll(tasks)
        this.isDone = isDone
    }
}