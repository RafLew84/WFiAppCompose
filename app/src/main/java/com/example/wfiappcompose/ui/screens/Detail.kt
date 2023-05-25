package com.example.wfiappcompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wfiappcompose.data.DataProvider
import com.example.wfiappcompose.lorem

@Composable
fun DetailView(
    id: String?
){
    val data by remember {
        mutableStateOf(DataProvider.institutes[id!!.toInt()])
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ImageCard(
            painter = painterResource(id = data.imageResource),
            contentDescription = data.title,
            title = data.title,
            info = data.info,
            index = id?.toInt() ?: 0,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            body = lorem
        )
    }
}