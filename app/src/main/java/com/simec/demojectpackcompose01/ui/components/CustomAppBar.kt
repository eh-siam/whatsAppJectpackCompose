package com.simec.demojectpackcompose01.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simec.demojectpackcompose01.R

/**
 * Created by Emdadul Haque Siam on 24,September,2025
 * Copyright (c): SIMEC System Ltd.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBarWithCard(title: String, onBackClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .statusBarsPadding(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        CenterAlignedTopAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(40.dp),
            title = {
                Text(text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 3.dp)
                ) },
            navigationIcon = {
                if (onBackClick != null) {
                    IconButton(onClick = onBackClick) {

                            Icon(
                                modifier = Modifier
                                    .size(45.dp)
                                    .padding(bottom = 2.dp)
                                    .background(Color.White),
                                painter = painterResource(id = R.drawable.arrow_blue),
                                contentDescription = "Back",
                                tint = Color.Unspecified
                            )
                    }
                }
            },colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White,
                titleContentColor = MaterialTheme.colorScheme.onBackground,
                navigationIconContentColor = MaterialTheme.colorScheme.onBackground )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCustomAppBar() {
    CustomAppBarWithCard(title = "Profile", onBackClick = {  })
}


