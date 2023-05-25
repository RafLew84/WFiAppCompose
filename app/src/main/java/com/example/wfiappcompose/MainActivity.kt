package com.example.wfiappcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.wfiappcompose.data.DataProvider
import com.example.wfiappcompose.data.DataProvider.institutes
import com.example.wfiappcompose.ui.Navigation
import com.example.wfiappcompose.ui.screens.ImageCard
import com.example.wfiappcompose.ui.screens.InstituteList
import com.example.wfiappcompose.ui.theme.WFiAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WFiAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (institutes.isEmpty())
                        DataProvider.getInstituteData(this)

                    Navigation()
                }
            }
        }
    }
}