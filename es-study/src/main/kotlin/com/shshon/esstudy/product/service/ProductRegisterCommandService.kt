package com.shshon.esstudy.product.service

import com.shshon.esstudy.product.domain.ProductRepository
import com.shshon.esstudy.product.service.dto.ProductRegisterCommand
import org.springframework.stereotype.Service

@Service
class ProductRegisterCommandService(
    private val productRepository: ProductRepository,
) {

    fun registerProduct(command: ProductRegisterCommand) {
        this.productRepository.save(product = command.toDomain())
    }
}
