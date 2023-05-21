package com.example.wfiappcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wfiappcompose.R
import com.example.wfiappcompose.data.DataProvider
import com.example.wfiappcompose.ui.theme.WFiAppComposeTheme

@Composable
fun InstituteList(){
    val data by remember {
        mutableStateOf(DataProvider.institutes.toList())
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ){
        items(data.size){index ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .clickable { /*TODO*/ },
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCard(
                    painter = painterResource(id = data[index].imageResource),
                    contentDescription = data[index].title,
                    title = data[index].title,
                    info = data[index].info
                )
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    info: String,
    modifier: Modifier = Modifier
){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable { },
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Box(modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()){
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
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
            ) {
                Text(text = info)
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

@Preview(showBackground = true)
@Composable
fun ImageCardPreview() {
    WFiAppComposeTheme {
        ImageCard(
            painter = painterResource(id = R.drawable.img_bib),
            contentDescription = "test",
            title = "test",
            info = "info"
        )
    }
}