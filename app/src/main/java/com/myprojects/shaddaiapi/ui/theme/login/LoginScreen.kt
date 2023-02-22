package com.myprojects.shaddaiapi.ui.theme.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.*
import com.myprojects.shaddaiapi.R
import com.myprojects.shaddaiapi.ui.theme.GreenCustom

@Composable
fun LoginScreen(){
        Content()
}

@Composable
fun Content(){

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 100.dp), contentAlignment = Alignment.TopCenter
        ) {
            Image(painter = painterResource(id = R.drawable.icon), contentDescription = "logo" )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topEnd = 20.dp, topStart = 30.dp))
                //.clip(shape = RoundedCornerShape(topLeft = 30.dp, topRight = 30.dp))
                .background(Color.White)
                .padding(10.dp)
        ) {

            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Text(
                        text = "Sign In",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        ),
                        fontSize = 30.sp
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(
                            value = emailValue.value,
                            onValueChange = {},
                            label = { Text(text = "Email Address") },
                            placeholder = { Text(text = "Email Address") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(fraction = 0.8f),

                            )
                        OutlinedTextField(
                            value = passwordValue.value,
                            onValueChange = {},
                            trailingIcon = {
                                IconButton(onClick = {}) {
                                    Icon(painter = painterResource(id = R.drawable.ic_eye), contentDescription = "password vista" )
                                }
                            },
                            label = { Text(text = "Password") },
                            placeholder = { Text(text = "Password") },
                            singleLine = true,
                            visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth(fraction = 0.8f)
                                .focusRequester(focusRequester = focusRequester) ,
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                               backgroundColor =  GreenCustom),
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Sign In", fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))
                        Text(
                            text = "Create An Account",
                            modifier = Modifier.clickable(onClick = {

                            })
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                    }

                }

            }
        }

    }
}


