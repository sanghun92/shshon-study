package com.shshon.customers.infra.domain.data_access

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class CustomerEntity(id: EntityID<UUID>): UUIDEntity(id = id) {
    companion object : UUIDEntityClass<CustomerEntity>(CustomerTable)
    var name by CustomerTable.name
}
