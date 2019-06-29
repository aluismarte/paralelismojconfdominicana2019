package edu.aluismarte.jconf.tests

import edu.aluismarte.jconf.domain.Work
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

/**
 * Created by aluis on 6/29/19.
 */
object DataLoader {

    @JvmStatic
    fun countAll(): Int {
        var count = 0
        transaction {
            count = Work.count()
            commit()
        }
        return count
    }

    @JvmStatic
    fun loadAll(): List<String> {
        var data: List<String> = mutableListOf()
        transaction(Connection.TRANSACTION_REPEATABLE_READ, 2) {
            data = Work.all().map { it.numbers }.toList()
        }
        return data
    }

    @JvmStatic
    fun loadByPart(offset: Int, cant: Int): List<String> {
        var data: List<String> = mutableListOf()
        transaction {
            data = Work.all().limit(cant, offset).map { it.numbers }.toList()
            commit()
        }
        return data
    }
}
