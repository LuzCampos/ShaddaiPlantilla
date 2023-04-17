package com.myprojects.shaddaiapi.domain.use_case

import com.myprojects.shaddaiapi.domain.CategoryItem
import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.repo.ServiceRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val serviceRepository: ServiceRepository) {
    suspend operator fun invoke(): List<ProductItem> {
        return serviceRepository.getProducts().shuffled()
    }
}