package com.myprojects.shaddaiapi.ui.theme.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.domain.use_case.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getProductsUseCase: GetProductUseCase) : ViewModel() {
    private val _products = MutableStateFlow(emptyList<ProductItem>())
    val products: StateFlow<List<ProductItem>> get() = _products

    init {
        getProducts()
    }

    private fun getProducts() {

        viewModelScope.launch {

            try {

                val products = getProductsUseCase()
                _products.value = products

            } catch (_: Exception) {}

        }

    }
}