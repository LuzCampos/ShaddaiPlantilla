package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.myprojects.shaddaiapi.domain.ProductItem

class CarritoViewModel : ViewModel(){
    private val _products = mutableStateListOf<ProductItem>()

    val products: List<ProductItem>
        get() = _products

    fun addProduct(product: ProductItem) {
        val existingProduct = _products.find { it._id == product._id }
        if (existingProduct != null) {
            existingProduct.quantity += 1
        } else {
            _products.add(product.copy(quantity = 1))
        }
    }

    fun removeProduct(product: ProductItem) {
        val existingProduct = _products.find { it._id == product._id }
        if (existingProduct != null) {
            if (existingProduct.quantity > 1) {
                existingProduct.quantity -= 1
            } else {
                _products.remove(existingProduct)
            }
        }
    }
}