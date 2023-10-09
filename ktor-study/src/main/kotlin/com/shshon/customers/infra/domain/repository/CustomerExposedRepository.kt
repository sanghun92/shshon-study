package com.shshon.customers.infra.domain.repository

import com.shshon.common.infra.data_access.DatabaseFactory.dbQuery
import com.shshon.customers.domain.Customer
import com.shshon.customers.domain.repository.CustomerRepository
import com.shshon.customers.infra.domain.data_access.CustomerTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class CustomerExposedRepository: CustomerRepository {

    override suspend fun save(customer: Customer): Customer? = dbQuery {
        val insertStatement = CustomerTable.insert {
            it[id] = customer.id
            it[name] = customer.name
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToCustomer)
    }

    override suspend fun findById(id: String): Customer? = dbQuery {
        CustomerTable
            .select { CustomerTable.id eq id }
            .map(::resultRowToCustomer)
            .singleOrNull()
    }

    private fun resultRowToCustomer(row: ResultRow) = Customer(
        id = row[CustomerTable.id],
        name = row[CustomerTable.name]
    )
}
