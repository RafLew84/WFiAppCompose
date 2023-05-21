package com.example.wfiappcompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wfiappcompose.ui.theme.WFiAppComposeTheme

@Composable
fun DetailView(
    text: String
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .clickable { },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(12.dp),
                fontSize = 240.sp,
                style = TextStyle(color = Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailViewPreview() {
    WFiAppComposeTheme {
        DetailView("1")
    }
}