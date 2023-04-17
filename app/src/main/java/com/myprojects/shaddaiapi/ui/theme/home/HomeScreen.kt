package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.myprojects.shaddaiapi.ui.theme.GreenCustom
import com.myprojects.shaddaiapi.R
import com.myprojects.shaddaiapi.domain.CategoryItem
import com.myprojects.shaddaiapi.domain.ProductItem
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(navController: NavController,
//               viewModelCart: CarritoViewModel
//homeViewModel: HomeViewModel
){
    val homeViewModel =
    hiltViewModel<HomeViewModel>()
    //viewModel(modelClass = HomeViewModel::class.java)
    //val product by homeViewModel.products.observeAsState()
    val products = homeViewModel.products.observeAsState(listOf()).value
    //val products by homeViewModel.products.collectAsState()
    val categories by homeViewModel.categories.collectAsState()
    var isLoading by remember { mutableStateOf(true) }

    println(" Nro de productos ${products.size}")
    println(" Nro de productos ${categories.size}")

    LaunchedEffect(true){
        delay(1000)
        isLoading = false
    }

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
            if (!isLoading){
                LazyColumn(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    content = {

                        item {
                            CategoriesRow(categories = categories)
                        }

                        item {
                            HomeGrid(products = products,navController
                                //viewModelCart
                            )
                        }
                    })
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                }
                // Show the progress indicator if the screen is loading
                CircularProgressIndicator()
            }


        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
           //     println(viewModelCart.products.size)
                navController.navigate("cart")
            }, backgroundColor = GreenCustom) {
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

@Composable
fun CategoriesRow(categories : List<CategoryItem>){
    LazyRow ( 
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        items(categories) { category : CategoryItem ->
            CategoryItemRow(categoryItem = category)
        }
    }
}

@Composable
fun CategoryItemRow(categoryItem: CategoryItem){
    Button(
        modifier = Modifier.padding(end = 4.dp),
        onClick = {
        //your onclick code here
    },elevation =  ButtonDefaults.elevation(
        defaultElevation = 10.dp,
        pressedElevation = 15.dp,
        disabledElevation = 0.dp
    ),  colors = ButtonDefaults.buttonColors(GreenCustom) ) {
        Text(text = "${categoryItem.name}", color = Color.White)
    }
}

