package com.myprojects.shaddaiapi.domain

import com.myprojects.shaddaiapi.data.remote.model.ProductModel

data class ProductItem(
    val _id: String,
    val name: String,
    val photo: String,
    val price:Int
)

fun ProductModel.toProductItem() = ProductItem(_id, name, photo, price)