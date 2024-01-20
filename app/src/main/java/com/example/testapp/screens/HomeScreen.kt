package com.example.testapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.testapp.components.ItemCard
import com.example.testapp.data.ApiStatus
import com.example.testapp.data.utils.Api
import com.example.testapp.data.view.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(todoViewModel: TodoViewModel) {
    Scaffold(
        topBar = { TopAppBar(
            modifier = Modifier.shadow(elevation = 2.dp),
            title = { Text(text = "Todo Application") },
            actions = {
                IconButton(onClick = {},) {
                    Icon(imageVector = Icons.Outlined.Refresh, contentDescription ="" )
                }

                Spacer(modifier = Modifier.width(10.dp))
            }
        )
        }
    ) {paddingValues ->
        TodoList(todoViewModel = todoViewModel,paddingValues=paddingValues)
        }
    }


@Composable
fun TodoList(todoViewModel: TodoViewModel,paddingValues: PaddingValues) {
    Box (modifier = Modifier.padding(paddingValues)){
        when (val response = todoViewModel.response.value) {
            is ApiStatus.Loading -> {
                Text(text = "Loading...",)
            }
            is ApiStatus.Failure -> {
                Text(text = "${response.msg}")
            }
            is ApiStatus.Empty -> {}
            is ApiStatus.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                ) {
                    items(response.data) {
                        Spacer(modifier = Modifier.height(10.dp))
                        ItemCard(todoModel = it)
                    }
                }
            }
        }
    }
}