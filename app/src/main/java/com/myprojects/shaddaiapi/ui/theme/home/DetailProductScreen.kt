package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.myprojects.shaddaiapi.ui.theme.GreenCustom

@Composable
fun DetailProductScreen(_id: String?, homeViewModel: HomeViewModel, navController: NavController){
    if (_id != null) {
        homeViewModel.getProductById(_id)
    }
    val product = homeViewModel.product.observeAsState().value
    println(" Product Detail " +  product?.name)
    if (product != null)
            Column {
                TopAppBar(
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                    title = {
                        Text(text = product?.name ?: "", fontWeight = FontWeight.Bold)
                    }
                )
                AsyncImage(
                    model = product?.photo,
                    contentDescription = "photo product",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )
                Box(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Text(text = "Descripción :", fontWeight = FontWeight.Bold, color = GreenCustom)
                        Text(text = product?.description ?: "", modifier = Modifier.padding(20.dp))
                        Text(text = "Precio :", fontWeight = FontWeight.Bold, color = GreenCustom)
                        Text(text = product?.price.toString(),modifier = Modifier.padding(20.dp))
                    }
                }

            }
}