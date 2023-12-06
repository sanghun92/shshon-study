package com.shshon.esstudy.product.infra

import com.shshon.esstudy.config.ElasticsearchTestConfiguration
import com.shshon.esstudy.ext.TestContainersExtension
import com.shshon.esstudy.fixture.product.ProductFixture
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@TestContainersExtension
@SpringBootTest(classes = [
    ElasticsearchTestConfiguration::class,
    ProductAdaptor::class,
])
class ProductAdaptorTest {

    @Autowired
    private lateinit var sut: ProductAdaptor

    @Test
    fun `save 메서드 테스트`() {
        val product = ProductFixture.sample(
            name = "상품",
            price = 17_000,
            stock = 10,
        )

        val actual = sut.save(product = product)

        with(actual) {
            Assertions.assertEquals(product.id, this.id)
            Assertions.assertEquals(product.name, this.name)
            Assertions.assertEquals(product.price, this.price)
            Assertions.assertEquals(product.stock, this.stock)
            Assertions.assertEquals(product.grade, this.grade)
        }
    }

    @Test
    fun `findAllByName 메서드 테스트`() {
        sut.save(product = ProductFixture.sample(name = "상품"))
        sut.save(product = ProductFixture.sample(name = "상품"))
        sut.save(product = ProductFixture.sample(name = "상품"))

        val actual = sut.findAllByName(name = "상품")

        Assertions.assertEquals(3, actual.size)
    }
}
