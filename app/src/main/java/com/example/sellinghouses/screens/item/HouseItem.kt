package com.example.sellinghouses.screens.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sellinghouses.R
import com.example.sellinghouses.ui.theme.SellingHousesTheme
import com.example.softwareproject.screens.model.House

@Composable
fun HouseItem(house: House) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(R.drawable.home), "content description",
            Modifier
                .width(120.dp)
                .height(100.dp)
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = house.address,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = house.information,
                color = Color.White,
                fontSize = 17.sp
            )
        }

    }
}


@Composable
@Preview(showBackground = true)
fun previewH() {
    SellingHousesTheme(darkTheme = true) {
        HouseItem(
            House(
                "",
                seller = "zahra",
                address = "123",
                information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
            )
        )

    }
}