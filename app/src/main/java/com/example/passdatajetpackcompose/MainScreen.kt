package com.example.passdatajetpackcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    name: Array<String>,
    ingradent: Array<String>,
    navController: NavController,
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    currentLanguage: String = "English"
) {
    val filteredIndices = name.indices.filter {
        val tName = MiningTranslations.translateName(name[it], currentLanguage)
        val tDesc = MiningTranslations.translateDescription(ingradent[it], currentLanguage)
        tName.contains(searchQuery, ignoreCase = true) || tDesc.contains(searchQuery, ignoreCase = true)
    }

    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(filteredIndices.size) { index ->
            val originalIndex = filteredIndices[index]
            ColumnItem(
                title = name,
                ingradent = ingradent,
                itemIndex = originalIndex,
                navController = navController,
                currentLanguage = currentLanguage
            )
        }
    }
}

@Composable
fun ColumnItem(
    title: Array<String>,
    ingradent: Array<String>,
    itemIndex: Int,
    navController: NavController,
    modifier: Modifier = Modifier,
    currentLanguage: String = "English"
) {
    val displayName = MiningTranslations.translateName(title[itemIndex], currentLanguage)
    val displayDesc = MiningTranslations.translateDescription(ingradent[itemIndex], currentLanguage)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("DetailScreen/$itemIndex")
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = displayName,
                    color = Color(0xFF003366),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                if (displayDesc.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = displayDesc,
                        color = Color.DarkGray,
                        fontSize = 14.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
