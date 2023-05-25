package com.example.wfiappcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    info: String,
    index: Int,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = { },
    body: String = ""
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onClick(index) },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            InstituteImage(painter, contentDescription)
            Gradient()
            Text(
                text = title,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp),
                fontSize = 24.sp,
                style = TextStyle(color = Color.White)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = info)
            Text(text = body, modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp ))
        }
    }
}

@Composable
private fun InstituteImage(
    painter: Painter,
    contentDescription: String
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun Gradient() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 450f
                )
            )
    )
}