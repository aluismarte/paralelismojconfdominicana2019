package edu.aluismarte.jconf.tests

import edu.aluismarte.jconf.domain.Work
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Created by aluis on 6/29/19.
 */
object DataLoader {

    @JvmStatic
    fun countAll(): Int {
        var count = 0
        transaction {
            count = Work.count()
        }
        return count
    }

    @JvmStatic
    fun loadAll(): List<Work> {
        var data: List<Work> = mutableListOf()
        transaction {
            data = Work.all().toList()
            commit()
        }
        return data
    }

    @JvmStatic
    fun loadByPart(offset: Int, cant: Int): List<Work> {
        var data: List<Work> = mutableListOf()
        transaction {
            data = Work.all().limit(cant, offset).toList()
            commit()
        }
        return data
    }
}
