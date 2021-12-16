package com.example.sellinghouses.screens.item

import android.graphics.Paint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sellinghouses.ui.theme.SellingHousesTheme

@Composable
fun FilteringItem(
    backColor: Color,
    buttonColor: Color,
    textColor: Color ,
    isRentall :Boolean
) {


    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),

        ) {
        Column(
            modifier = Modifier
                .background(backColor)
                .padding(6.dp)
        ) {
            val animationTargetState = remember { mutableStateOf(if (isRentall) 0f else 1000f) }
            var isRental = remember { mutableStateOf(isRentall)}
            DrawRec(buttonColor, textColor = textColor, animationTargetState , isRental)
        }

    }
}

@Composable
fun DrawRec(
    buttonColor: Color,
    textColor: Color,
    animationTargetState: MutableState<Float>,
    isRental: MutableState<Boolean>,
) {
    val animatedFloatState = animateFloatAsState(
        // Whenever the target value changes, new animation
        // will start to the new target value
        targetValue = animationTargetState.value,
        animationSpec = tween(durationMillis = 700)
    )
    Canvas(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .clickable {
                // Change the target state to start the animation
                animationTargetState.value = if (isRental.value) 1000f else 0f
                isRental.value = if (isRental.value) false else true
            },

        onDraw = {


            drawRoundRect(
                color = buttonColor,
                size = Size(
                    width = (size.width / 2),
                    height = (size.height)
                ),
                topLeft = Offset(
                    x = size.width * animatedFloatState.value / 2000,
                    y = 0.dp.toPx()
                ),
                cornerRadius = CornerRadius(
                    x = 18.dp.toPx(),
                    y = 18.dp.toPx()
                )
            )

            val paint = Paint()
            val textSize = size.height / 3
            paint.textAlign = Paint.Align.CENTER
            paint.textSize = textSize
            paint.color = textColor.toArgb()
            drawIntoCanvas {
                it.nativeCanvas.drawText("BUY", center.x / 2, (size.height + textSize) / 2, paint)
                it.nativeCanvas.drawText(
                    "RENT", 3 * center.x / 2, (size.height + textSize) / 2, paint
                )

            }

        })
}


@Preview(showBackground = true)
@Composable
fun FilteringItems() {
    SellingHousesTheme(darkTheme = false) {
        FilteringItem(
            MaterialTheme.colors.primary,
            MaterialTheme.colors.primaryVariant,
            MaterialTheme.colors.secondary,
            false
        )

    }
}






