package edu.aluismarte.jconf.domain

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable

/**
 * Created by aluis on 6/28/19.
 */
object Works : LongIdTable() {
    val numbers = text("numbers");
}

class Work(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Work>(Works)

    var numbers by Works.numbers
}