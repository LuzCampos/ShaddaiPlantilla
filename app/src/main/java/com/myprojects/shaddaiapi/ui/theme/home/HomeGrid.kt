package com.myprojects.shaddaiapi.ui.theme.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.myprojects.shaddaiapi.domain.ProductItem
import com.myprojects.shaddaiapi.ui.theme.GreenCustom
import com.myprojects.shaddaiapi.ui.theme.circularstdblack
import com.myprojects.shaddaiapi.ui.theme.circularstdbold
import com.myprojects.shaddaiapi.ui.theme.circularstdbook

@Composable
fun HomeGrid(products: List<ProductItem>){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp) ,
        columns = GridCells.Fixed( 2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),){
        header {
            Text(
                modifier = Modifier.padding(vertical = 10.dp),
                text = "Últimos productos",
                style = MaterialTheme.typography.h5.copy(
                    fontFamily = circularstdbook
                )
            )
        }
        items(products) { product: ProductItem ->
            CardProduct(productItem = product)
        }
    }
}

@Composable
fun CardProduct(productItem: ProductItem, context: Context = LocalContext.current.applicationContext){
    Card(shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 5.dp,
        modifier = Modifier
            .clickable {
                Toast
                    .makeText(context, "Click", Toast.LENGTH_SHORT)
                    .show()
            }
            .size(width = 100.dp, height = 280.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(model = productItem.photo
                ,contentScale = ContentScale.Fit
                ,contentDescription = "productimg")
            textandbutton(productItem = productItem)
        }
    }
}

@Composable
fun textandbutton(productItem: ProductItem){
    Row(modifier = Modifier.padding(20.dp)) {
        Column(modifier = Modifier
            .weight(1f)
         //   .padding(end = 5.dp)
        ) {
            Text(
                text = productItem.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = circularstdbook
                )
            )
            Text(
                text = "S/. ${productItem.price}.00",
                style = TextStyle(
                    color = GreenCustom,
                    fontSize = 10.sp,
                    fontFamily = circularstdbold
                )
            )
        }
        IconButton(
            onClick = { },
            modifier = Modifier.background(
                color = Color(0xff0DA54B),
                shape = RoundedCornerShape(10.dp)
            )
        ) {
            Icon(Icons.Default.Add, tint = Color.White,  contentDescription = null)
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}