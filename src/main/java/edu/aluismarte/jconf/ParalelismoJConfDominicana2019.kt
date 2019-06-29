package edu.aluismarte.jconf

import edu.aluismarte.jconf.domain.Works
import edu.aluismarte.jconf.tests.MonoThread
import edu.aluismarte.jconf.tests.MultiThread
import edu.aluismarte.jconf.utils.Constants
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Created by aluis on 6/17/19.
 */
object ParalelismoJConfDominicana2019 {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello JConf Dominicana 2019!")
        Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Works)
            if (Works.selectAll().count() == 0) {
                println("No data, creating DB")
                for (i in 0 until Constants.ROWS_ON_DB) {
                    val line = StringBuilder()
                    val numberList = Constants.numberList()
                    Constants.shuffle(numberList)
                    for (j in numberList.indices) {
                        line.append(numberList.get(j))
                        if (j < numberList.size - 1) {
                            line.append(",")
                        }
                    }
                    Works.insert {
                        it[numbers] = line.toString()
                    }
                }
                println("Data Created")
            } else {
                println("Data already exist")
            }
        }
        MonoThread.run()
        println("--------------------------------------------------------")
        MultiThread.run()
    }
}
