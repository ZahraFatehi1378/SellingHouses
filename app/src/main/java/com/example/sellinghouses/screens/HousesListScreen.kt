package com.example.sellinghouses.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sellinghouses.ui.theme.SellingHousesTheme
import com.example.sellinghouses.screens.item.HouseItem
import com.example.softwareproject.screens.model.House

@Composable
fun HousesListScreen() {
    val list = listOf(
        House(
            "",
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        )
        ,
        House(
            "",
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        )
    )
    Column(
        Modifier
            .background(MaterialTheme.colors.primary)
            .padding(15.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyColumn(
                //    contentPadding = PaddingValues(all = 10.dp),
                Modifier.background(MaterialTheme.colors.secondary),
                verticalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                items(items = list) { house ->
                    HouseItem(house = house)

                }

            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun preview() {
    SellingHousesTheme(darkTheme = false) {
        HousesListScreen()
    }
}