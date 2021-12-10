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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sellinghouses.R
import com.example.sellinghouses.ui.theme.SellingHousesTheme

@Composable
fun ImageCard(
    //  painter: Painter,
    title: String,
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .background(MaterialTheme.colors.primary)
        ,
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(MaterialTheme.colors.primary)
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
                                    MaterialTheme.colors.primary
                                ),
                                startY = 50f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Column {
                        Text(
                            text = title,
                            color = MaterialTheme.colors.secondary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "icon",
                                tint = MaterialTheme.colors.secondary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "3",
                                color = MaterialTheme.colors.secondary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )

                        }


                    }

                }
            }

            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .padding(6.dp),

                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "kdflnlkfds",
                    color = MaterialTheme.colors.secondary,
                    fontSize = 16.sp
                )

                Text(
                    text = "house.information",
                    color = MaterialTheme.colors.secondary,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun ImageCardData() {
    SellingHousesTheme(darkTheme = true) {

        val title = "Sample Text Title"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ImageCard(
                //    painter = painter,
                title = title,
            )
        }
    }
}