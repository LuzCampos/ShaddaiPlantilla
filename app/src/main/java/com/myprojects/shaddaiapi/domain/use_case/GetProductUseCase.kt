package com.myprojects.shaddaiapi.domain.use_case

import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.repo.ProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend operator fun invoke(): List<ProductItem> {

        return productRepository.getProducts().shuffled()

    }
}