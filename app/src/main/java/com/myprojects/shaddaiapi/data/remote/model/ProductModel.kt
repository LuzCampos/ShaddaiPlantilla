package com.myprojects.shaddaiapi.data.remote.model

data class ProductModel(val _id: String,
                        val name: String,
                        val photo: String,
                        val description: String,
                        val price: Double,
                        val category: CategoryModel,
                        var quantity:Int,

)