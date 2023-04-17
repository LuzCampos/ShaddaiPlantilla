package com.myprojects.shaddaiapi.domain

import com.myprojects.shaddaiapi.data.remote.model.CategoryModel

data class CategoryItem (
    val _id: String,
    val name: String
)

fun CategoryModel.toCategoryItem() = CategoryItem(_id, name)