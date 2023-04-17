package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.myprojects.shaddaiapi.domain.CartItem

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<CartItem>()
}