package com.shshon.customers.infra.domain.data_access

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CustomerTable: Table("customer") {
    val id: Column<String> = varchar("id", 30)
    val name: Column<String> = varchar("name", 20)

    override val primaryKey = PrimaryKey(id, name = "pk_customer_id")
}
