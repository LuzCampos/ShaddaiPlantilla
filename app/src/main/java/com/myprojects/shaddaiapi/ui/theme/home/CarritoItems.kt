package com.myprojects.shaddaiapi.ui.theme.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.myprojects.shaddaiapi.domain.ProductItem

@Composable
fun CarritoItemsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
            title = {
                Text(text = "Carrito de compras", fontWeight = FontWeight.Bold)
                }
            )
        LazyColumn(){
            item{
                ShoppingCartItem(onAddClicked = { }, onRemoveClicked = {  })
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp))
            CartPrice(title = "Precio :", price = "24")
            CartPrice(title = "TOTAL :", price = "24")
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp).clip(
                RoundedCornerShape(20.dp))) {
                Text("CHECKOUT")
            }
        }
        }

    }

@Composable
fun ShoppingCartItem(onAddClicked: () -> Unit, onRemoveClicked: () -> Unit) {
    Card(
        elevation = 2.dp,
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(text = "AGUJAS DENTALES NIPRO")
                Text(text = "24.00")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onAddClicked) {
                    Icon(Icons.Default.AddCircle, contentDescription = "Add")
                }
                IconButton(onClick = onRemoveClicked) {
                    Icon(Icons.Default.Delete, contentDescription = "Remove")
                }
                Text(text = "x2")
            }
        }
    }
}

@Composable
fun CartPrice(title:String,price:String){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "$title", fontSize = 16.sp
        )
        Text(text = "S/. $price.00", fontSize = 20.sp)
    }
}