package com.example.wfiappcompose.ui.screens

import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable.Orientation
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.wfiappcompose.R
import com.example.wfiappcompose.data.DataProvider
import com.example.wfiappcompose.ui.theme.WFiAppComposeTheme

@Composable
fun InstituteList(onClick: (Int) -> Unit) {
    val data by remember { mutableStateOf(DataProvider.institutes.toList()) }
    var numOfColumns by remember { mutableStateOf(1) }

    numOfColumns = getColumnsFromOrientation()

    LazyVerticalGrid(
        columns = GridCells.Fixed(numOfColumns),
        modifier = Modifier.fillMaxSize()
    ) {
        items(data.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageCard(
                    painter = painterResource(id = data[index].imageResource),
                    contentDescription = data[index].title,
                    title = data[index].title,
                    info = data[index].info,
                    onClick = onClick,
                    index = index
                )
            }
        }
    }
}

@Composable
private fun getColumnsFromOrientation(): Int {
    var orientation by remember { mutableStateOf(Configuration.ORIENTATION_PORTRAIT) }
    val configuration = LocalConfiguration.current

    LaunchedEffect(configuration) {
        snapshotFlow { configuration.orientation }
            .collect { orientation = it }
    }

    return when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> { 1 }
        else -> { 2 }
    }
}

