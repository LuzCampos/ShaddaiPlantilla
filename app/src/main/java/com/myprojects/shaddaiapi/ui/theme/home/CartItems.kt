package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CartScreen(cartViewModel:CartViewModel){
    val cartItems = cartViewModel.cartItems
    Column {
        Text(text = "Cart Items")
        LazyColumn {
            items(cartItems) { item ->
                Text(text = "${item.name} x${item.cantidad}")
            }
        }
    }
}