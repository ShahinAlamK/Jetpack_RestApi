package com.example.testapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ItemCard() {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE9E9E9), shape = RoundedCornerShape(5.dp))
    ){
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            text = "Hello Todo")
    }
}