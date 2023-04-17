package com.myprojects.shaddaiapi.data.remote.model

data class ItemProductModel(
    val _id: String,
//    val category: Category,
    val name: String,
    val photo: String,
    val price: Double,
    var quantity: Int,

)