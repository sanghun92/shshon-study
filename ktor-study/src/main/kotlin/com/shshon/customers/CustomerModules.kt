package com.shshon.customers

import com.shshon.customers.api.CustomerCommandApi
import com.shshon.customers.domain.repository.CustomerRepository
import com.shshon.customers.domain.repository.MockCustomerRepository
import com.shshon.customers.service.CustomerReadService
import com.shshon.customers.service.CustomerRegisterService
import com.shshon.customers.use_case.GetCustomerUseCase
import com.shshon.customers.use_case.RegisterCustomerUseCase
import com.shshon.plugins.Api
import org.koin.dsl.bind
import org.koin.dsl.module

private val apiModules = listOf(module(createdAtStart = true) {
    single<CustomerCommandApi> { CustomerCommandApi(get(), get()) } bind Api::class
})

private val repositoryModules = listOf(module(createdAtStart = true) {
    single<CustomerRepository> { MockCustomerRepository() }
})

private val serviceModules = listOf(module(createdAtStart = true) {
    single<CustomerRegisterService> { CustomerRegisterService(get()) }
    single<CustomerReadService> { CustomerReadService(get()) }
})

private val useCaseModules = listOf(module(createdAtStart = true) {
    single<GetCustomerUseCase> { GetCustomerUseCase(get()) }
    single<RegisterCustomerUseCase> { RegisterCustomerUseCase(get()) }
})

val customerModules = listOf(
    apiModules,
    repositoryModules,
    serviceModules,
    useCaseModules,
)
