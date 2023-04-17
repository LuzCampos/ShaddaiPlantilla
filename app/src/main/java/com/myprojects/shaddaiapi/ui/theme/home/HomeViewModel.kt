package com.myprojects.shaddaiapi.ui.theme.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.shaddaiapi.data.remote.RemoteService
import com.myprojects.shaddaiapi.data.remote.model.ProductModel
import com.myprojects.shaddaiapi.domain.CategoryItem
import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.domain.use_case.GetCategoryUseCase
import com.myprojects.shaddaiapi.domain.use_case.GetProductItemUseCase
import com.myprojects.shaddaiapi.domain.use_case.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getProductsUseCase: GetProductUseCase, private val getCategoryUseCase: GetCategoryUseCase, private val getProductItemUseCase: GetProductItemUseCase,private val remoteService: RemoteService ) : ViewModel() {
     private val _products = MutableLiveData<List<ProductItem>>()
    val products: LiveData<List<ProductItem>> get() = _products
    private val _product = MutableLiveData<ProductItem>()
    val product: LiveData<ProductItem> get() = _product

    private val _categories = MutableStateFlow(emptyList<CategoryItem>())
    val categories: StateFlow<List<CategoryItem>> get() = _categories

  //  private val _products = MutableStateFlow(emptyList<ProductItem>())
   // val products: StateFlow<List<ProductItem>> get() = _products



    init {
        getProducts()
        getCategories()

    }

    private fun getProducts() {

        viewModelScope.launch {

            try {

                val products = getProductsUseCase()
                _products.value = products

            } catch (_: Exception) {}

        }

    }

    fun getProductById(id: String) {

        viewModelScope.launch {

            try {

                val product = getProductItemUseCase(id)
                _product.value = product

            } catch (_: Exception) {}

        }

    }

    private fun getCategories() {

        viewModelScope.launch {

            try {

                val categories = getCategoryUseCase()
                _categories.value = categories

            } catch (_: Exception) {}

        }

    }
}