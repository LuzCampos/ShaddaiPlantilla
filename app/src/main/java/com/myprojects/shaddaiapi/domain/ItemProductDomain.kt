package com.myprojects.shaddaiapi.domain

import com.myprojects.shaddaiapi.data.remote.model.ItemProductModel

data class ItemProductDomain (
    val _id: String,
    val name: String,
    val photo: String,
    val price:Double,
    var quantity:Int,
)

fun ItemProductModel.toItemProductDomain() = ItemProductDomain(_id, name, photo, price, quantity)