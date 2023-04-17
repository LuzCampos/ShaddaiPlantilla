package com.myprojects.shaddaiapi.domain

import com.myprojects.shaddaiapi.data.remote.model.CategoryModel
import com.myprojects.shaddaiapi.data.remote.model.ProductModel

data class ProductItem(
    val _id: String,
    val name: String,
    val photo: String,
    val description: String,
    val category: CategoryModel,
    val price:Double,
    var quantity:Int,
)

fun ProductModel.toProductItem() = ProductItem(_id, name, photo, description, category, price, quantity)