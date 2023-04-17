package com.myprojects.shaddaiapi.domain.use_case


import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.repo.ServiceRepository
import javax.inject.Inject

class GetProductItemUseCase  @Inject constructor(private val serviceRepository: ServiceRepository)  {
      suspend operator fun invoke(_id : String): ProductItem {
      return serviceRepository.getProduct(_id)
        }
}