package com.myprojects.shaddaiapi.domain.use_case

import com.myprojects.shaddaiapi.domain.CategoryItem
import com.myprojects.shaddaiapi.repo.ServiceRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val serviceRepository: ServiceRepository) {

   suspend operator fun invoke(): List<CategoryItem>{
      return serviceRepository.getCategories().shuffled()
  }

}