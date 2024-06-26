package com.example.gitsimpledemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gitsimpledemo.R

/**
 * Author: Ryu
 * Date: 2024/05/25
 * Description: show when first fetch data
 */

@Composable
fun InitPage(
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(R.drawable.process),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(128.dp)
                    .width(128.dp)
            )
            Text(
                stringResource(id = R.string.init_data),
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}


@Preview
@Composable
fun InitPagePreview() {
    InitPage()
}