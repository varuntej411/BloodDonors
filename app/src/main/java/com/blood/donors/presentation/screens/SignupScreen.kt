package com.blood.donors.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.blood.donors.MainNavGraphs.Route
import com.blood.donors.R

@Composable
fun SignupScreen(
    navController: NavHostController,
    loginClicked: (String, String) -> Unit
) {

    val context = LocalContext.current

    val registerText = buildAnnotatedString {
        pushStringAnnotation("", "")
        pushStyle(
            style = SpanStyle(
                color = Color.Black,
                fontSize = 16.sp,
                textDecoration = TextDecoration.None
            )
        )
        append("Already Registered? ")
        pop()
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Login")
        }
        pop()
    }

    var mail by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    val icon =
        if (passwordVisibility) painterResource(id = R.drawable.password_visibility_on) else painterResource(
            id = R.drawable.password_visibility_off
        )

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 60.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.elevatedCardColors(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
                    .height(150.dp)
                    .width(150.dp),
                alignment = Alignment.Center
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login Here !",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    value = mail,
                    onValueChange = { mail = it },
                    label = {
                        Text(
                            text = "Email Id",
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Enter Your Email Id",
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedLeadingIconColor = Color.Blue,
                        unfocusedLeadingIconColor = Color.Gray,
                        focusedLabelColor = Color.Blue,
                        unfocusedLabelColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.LightGray,
                        unfocusedPlaceholderColor = Color.Red,
                        errorTextColor = Color.Red,
                        errorContainerColor = Color.White,
                        errorPlaceholderColor = Color.Red,
                        errorLeadingIconColor = Color.Red,
                        errorIndicatorColor = Color.Red,
                        errorLabelColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = true,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = ""
                        )
                    },
                    isError = true,
                    singleLine = true
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp),
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Password",
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter Your Password",
                            fontSize = 16.sp,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Black,
                            textAlign = TextAlign.Start,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedLeadingIconColor = Color.Blue,
                        unfocusedLeadingIconColor = Color.Gray,
                        focusedLabelColor = Color.Blue,
                        unfocusedLabelColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Blue,
                        unfocusedIndicatorColor = Color.LightGray,
                        unfocusedPlaceholderColor = Color.Red,
                        errorTextColor = Color.Red,
                        errorContainerColor = Color.White,
                        errorPlaceholderColor = Color.Red,
                        errorLeadingIconColor = Color.Red,
                        errorIndicatorColor = Color.Red,
                        errorLabelColor = Color.White
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }
                        ) {
                            Icon(
                                painter = icon,
                                contentDescription = "password"
                            )
                        }
                    },
                    isError = true,
                    singleLine = true,
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
                )

                ElevatedButton(
                    onClick = {
                        loginClicked.invoke(mail, password)
                    },
                    modifier = Modifier
                        .height(75.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "SignUp",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.labelMedium
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Route.SignupScreen.screen)
                        },
                    text = registerText,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewSignUpScreen() {
    SignupScreen(
        navController = rememberNavController(),
        loginClicked = { _, _ -> }
    )
}

