package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.myprojects.shaddaiapi.ui.theme.GreenCustom
import com.myprojects.shaddaiapi.R

@Composable
fun HomeScreen(){

    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val products by homeViewModel.products.collectAsState()
    println(" Nro de productos ${products.size}")

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Spacer(modifier = Modifier.fillMaxSize())
            }, navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Search, tint = GreenCustom, contentDescription = "backIcon"
                    )
                }
            }, backgroundColor = Color.White, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.List, contentDescription = null, tint = GreenCustom)
                }
            })
        },
        content = {
            HomeGrid(products = products)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = GreenCustom) {
                    Icon(
                        painterResource(id = R.drawable.ic_outline_shopping_cart_24),
                        tint = Color.White,
                        contentDescription = "floatingbuttoncart")
            }
        },
        //Icon(painterResource(id = R.drawable.), contentDescription = ),
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
    )

}

