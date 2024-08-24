package com.blood.donors.presentation.customComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blood.donors.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CustomTextField(
    icon: @Composable () -> Unit,
    title: String,
    hint: String
) {

    val context = LocalContext.current

    var textField by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        value = textField,
        onValueChange = { textField = it },
        label = {
            Text(
                text = title,
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
                text = hint,
                fontSize = 14.sp,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        trailingIcon = {
            icon.invoke()
        },
        singleLine = true,
        isError = false,
        colors = TextFieldDefaults.colors(
            focusedLeadingIconColor = Color.Red,
            unfocusedLeadingIconColor = Color.Gray,
            focusedLabelColor = Color.Red,
            unfocusedLabelColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Red,
            unfocusedIndicatorColor = Color.LightGray,
            unfocusedPlaceholderColor = Color.Red,
            errorTextColor = Color.Red,
            errorContainerColor = Color.White,
            errorPlaceholderColor = Color.Red,
            errorLeadingIconColor = Color.Red,
            errorIndicatorColor = Color.Red,
            errorLabelColor = Color.White
        )
    )

}

@Preview
@Composable
fun PreviewCustomTextField() {
    CustomTextField(
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = ""
            )
        },
        title = "",
        hint = ""
    )
}