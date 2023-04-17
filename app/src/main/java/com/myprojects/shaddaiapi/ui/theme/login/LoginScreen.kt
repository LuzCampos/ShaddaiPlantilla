package com.myprojects.shaddaiapi.ui.theme.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.myprojects.shaddaiapi.R
import com.myprojects.shaddaiapi.ui.theme.GreenCustom

@Composable
fun LoginScreen(navController: NavController){
        Content(navController)
}

@Composable
fun Content(navController: NavController){

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            
        Login(modifier = Modifier.align(Alignment.Center), emailValue, passwordValue, passwordVisibility, focusRequester, navController)

    }
}

@Composable
fun Login(modifier: Modifier,
          emailValue: MutableState<String>,
          passwordValue: MutableState<String>,
          passwordVisibility: MutableState<Boolean>,
          focusRequester: FocusRequester,
          navController: NavController){
    Column(
       modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Ingresar",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            ), fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(emailValue)
        PasswordField(passwordValue, passwordVisibility , focusRequester)
        Spacer(modifier = Modifier.padding(14.dp))
        LoginButton(navController)
        Spacer(modifier = Modifier.padding(6.dp))
        CreateAccount(navController)
    }
}

@Composable
fun HeaderImage(modifier: Modifier){
    Box(
        modifier = modifier
    ) {
        Image(painter = painterResource(id = R.drawable.icon), contentDescription = "logo" )
    }
}

@Composable
fun EmailField(emailValue: MutableState<String>){
    OutlinedTextField(
        value = emailValue.value,
        onValueChange = {
            emailValue.value = it
        },
        label = { Text(text = "Email Address") },
        placeholder = { Text(text = "Email Address") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(fraction = 0.8f),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun PasswordField(passwordValue: MutableState<String>, passwordVisibility: MutableState<Boolean>,focusRequester: FocusRequester){
    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = {
            passwordValue.value = it
        },
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun LoginButton(navController: NavController){
    Button(
        onClick = {
            navController.navigate("home")
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor =  GreenCustom),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(50.dp)
    ) {
        Text(text = "Sign In", fontSize = 20.sp)
    }
}

@Composable
fun CreateAccount(navController: NavController){
    Text(
        text = "Create An Account",
        color = GreenCustom,
        modifier = Modifier.clickable(onClick = {
            navController.navigate("register")
        }),
        textAlign = TextAlign.Center
    )
}


