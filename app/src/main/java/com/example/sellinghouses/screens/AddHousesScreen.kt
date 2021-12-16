package com.example.sellinghouses.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.sellinghouses.screens.item.FilteringItem
import com.example.sellinghouses.ui.theme.SellingHousesTheme

@Composable
fun AddHousesScreen() {

    Scaffold(backgroundColor = MaterialTheme.colors.primary) {
        var price by remember {
            mutableStateOf("")
        }
        var location by remember {
            mutableStateOf("")
        }
        var info by remember {
            mutableStateOf("")
        }
        var bed by remember {
            mutableStateOf("")
        }
        var baths by remember {
            mutableStateOf("")
        }
        var space by remember {
            mutableStateOf("")
        }
        var isRental by remember {
            mutableStateOf(false)
        }


        Card(
            Modifier
                .padding(15.dp),
            shape = RoundedCornerShape(32.dp),
            backgroundColor = MaterialTheme.colors.primaryVariant
        ) {

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                TextFields(location, { location = it }, "location" , false)
                Spacer(modifier = Modifier.height(8.dp))
                TextFields(price, { price = it }, "price", false)
                Spacer(modifier = Modifier.height(8.dp))
                TextFields(info, { info = it }, "information", false)
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Surface(modifier = Modifier.weight(1f),color = ( MaterialTheme.colors.primaryVariant)) {
                        TextFields(bed, { bed = it }, "beds" , true)
                    }
                    Surface(modifier = Modifier.weight(1f),color = ( MaterialTheme.colors.primaryVariant)) {
                        TextFields(baths, { baths = it }, "baths" , true)
                    }
                    Surface(modifier = Modifier.weight(2f), color = ( MaterialTheme.colors.primaryVariant)) {
                        TextFields(space, { space = it }, "space by sqft" , true)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row {
                    Button(
                        modifier = Modifier.height(56.dp),
                        onClick = {},
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)

                    ) {
                        Text(
                            text = "upload pic",
                            color = MaterialTheme.colors.secondary
                        )

                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    FilteringItem(MaterialTheme.colors.primary, MaterialTheme.colors.onPrimary , MaterialTheme.colors.secondary , false)
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)

                ) {
                    Text(
                        text = "submit",
                        color = MaterialTheme.colors.primary
                    )

                }

            }
        }

    }
}

@Composable
fun TextFields(value: String, onValueChange: (String) -> Unit, label: String , isNumerical :Boolean) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colors.secondary
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.secondary,
            textColor = MaterialTheme.colors.secondary

        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isNumerical)KeyboardType.Number else KeyboardType.Text
        )
    )
}



@SuppressLint("ComposableNaming")
@Composable
@Preview
fun previewww2() {
    SellingHousesTheme(darkTheme = true) {
        AddHousesScreen()

    }
}



