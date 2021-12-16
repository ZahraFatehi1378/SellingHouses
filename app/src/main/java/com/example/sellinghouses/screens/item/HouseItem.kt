package com.example.sellinghouses.screens.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sellinghouses.R
import com.example.sellinghouses.ui.theme.SellingHousesTheme
import com.example.softwareproject.screens.model.House

@Composable
fun HouseItem(
    house: House
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant),
            verticalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier.height(200.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.home),
                    contentDescription = "house pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colors.primaryVariant
                                ),
                                startY = 50f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        ,
                    contentAlignment = Alignment.BottomStart
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(start = 12.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "$1223",
                                color = MaterialTheme.colors.secondary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                            Text(
                                text = "1 BED | 1 Baths | 53 sqft",
                                color = MaterialTheme.colors.secondary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }

                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = "icon",
                            tint = Color.Gray,
                            modifier = Modifier
                                .padding(end = 10.dp , bottom = 5.dp , top = 5.dp)
                        )
                    }

                }
            }
            Text(
                text = "germany,Topaz residences",
                color = MaterialTheme.colors.secondary,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 12.dp , bottom = 12.dp),
                fontWeight = FontWeight.Bold,

            )
        }
    }
}


@Composable
@Preview(showBackground = false)
fun previewH() {
    SellingHousesTheme(darkTheme = false) {
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