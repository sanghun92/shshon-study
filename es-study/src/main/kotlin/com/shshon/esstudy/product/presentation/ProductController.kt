package com.shshon.esstudy.product.presentation

import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.presentation.dto.RegisterProductRequest
import com.shshon.esstudy.product.service.ProductQueryService
import com.shshon.esstudy.product.service.ProductRegisterCommandService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productQueryService: ProductQueryService,
    private val productRegisterCommandService: ProductRegisterCommandService,
) {

    @GetMapping("/{name}")
    fun getProduct(@PathVariable name: String): List<Product> {
        return this.productQueryService.findAllByName(name = name)
    }

    @PostMapping
    fun registerProduct(@RequestBody request: RegisterProductRequest) {
        this.productRegisterCommandService.registerProduct(command = request.toCommand())
    }
}
