package edu.aluismarte.jconf.tests

import edu.aluismarte.jconf.domain.Work

/**
 * Created by aluis on 6/29/19.
 */
object DataLoader {

    @JvmStatic
    fun countAll(): Int {
        return Work.count();
    }

    @JvmStatic
    fun loadAll(): List<Work> {
        return Work.all().toList();
    }

    @JvmStatic
    fun loadByPart(offset: Int, cant: Int): List<Work> {
        return Work.all().limit(cant, offset).toList()
    }
}
