package com.example.sellinghouses.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sellinghouses.screens.item.FilteringItem
import com.example.sellinghouses.ui.theme.SellingHousesTheme
import com.example.sellinghouses.screens.item.HouseItem
import com.example.sellinghouses.screens.item.SearchView
import com.example.softwareproject.screens.model.House

@Composable
fun HousesListScreen() {
    val list = listOf(
        House(
            "",
            false,
            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;",
        ),
        House(
            "",

            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        ),
        House(
            "",
            false,

            seller = "zahra",
            address = "123",
            information = "123567dskfnklsnlkfsdn sjk;gng;kndfsg ;klfgndkln vkms avklnvmlmsflmsdf;lsm;"
        )
    )
    Column(
        Modifier
            .background(MaterialTheme.colors.primary)
            .padding(start = 15.dp , end = 15.dp ,top=10.dp)

    ) {
        val textState = remember { mutableStateOf(TextFieldValue("")) }
        Row {
            Surface(modifier = Modifier.weight(1.5f)) {
                SearchView(textState)
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Surface(modifier = Modifier.weight(1f)) {
                FilteringItem(MaterialTheme.colors.primaryVariant ,MaterialTheme.colors.primary ,MaterialTheme.colors.secondary , false)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
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
    SellingHousesTheme(darkTheme = true) {
        HousesListScreen()
    }
}