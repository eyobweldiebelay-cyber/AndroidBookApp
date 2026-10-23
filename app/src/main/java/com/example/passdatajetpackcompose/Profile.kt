package com.example.passdatajetpackcompose

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Profile(
    miningViewModel: MiningViewModel? = null,
    navController: NavController,
) {
    val items = listOf(
        ProfileGalleryItem(R.drawable.map, "Map of Ethio Mineral Location"),
        ProfileGalleryItem(R.drawable.dragline, "Dragline Excavator"),
        ProfileGalleryItem(R.drawable.belt_conveyor, "Belt Conveyor System"),
        ProfileGalleryItem(R.drawable.scrapers, "Earthmoving Scraper"),
        ProfileGalleryItem(R.drawable.dumper, "Mining Dump Truck"),
        ProfileGalleryItem(R.drawable.continou, "Continuous Miner"),
        ProfileGalleryItem(R.drawable.bucket_wheel_excavator, "Bucket-Wheel Excavator"),
        ProfileGalleryItem(R.drawable.ball_mill, "Ball Mill Grinder"),
        ProfileGalleryItem(R.drawable.bentonite, "Bentonite"),
        ProfileGalleryItem(R.drawable.chrome_chromite, "Chrome or Chromite"),
        ProfileGalleryItem(R.drawable.clay, "Clay"),
        ProfileGalleryItem(R.drawable.copper, "Copper"),
        ProfileGalleryItem(R.drawable.diatomite, "Diatomite"),
        ProfileGalleryItem(R.drawable.emerald, "Emerald"),
        ProfileGalleryItem(R.drawable.gold, "Gold"),
        ProfileGalleryItem(R.drawable.gypsum, "Gypsum"),
        ProfileGalleryItem(R.drawable.halite, "Halite"),
        ProfileGalleryItem(R.drawable.laterite_iron_ore, "Laterite Iron Ore"),
        ProfileGalleryItem(R.drawable.lignite, "Lignite"),
        ProfileGalleryItem(R.drawable.limestone, "Limestone"),
        ProfileGalleryItem(R.drawable.manganese, "Manganese"),
        ProfileGalleryItem(R.drawable.nickel, "Nickel"),
        ProfileGalleryItem(R.drawable.niobium, "Niobium"),
        ProfileGalleryItem(R.drawable.oil_and_gas, "Oil and Gas"),
        ProfileGalleryItem(R.drawable.platinum, "Platinum"),
        ProfileGalleryItem(R.drawable.oil_shale, "Oil Shale"),
        ProfileGalleryItem(R.drawable.perlite, "Perlite"),
        ProfileGalleryItem(R.drawable.potash, "Potash"),
        ProfileGalleryItem(R.drawable.sandstone, "Sandstone"),
        ProfileGalleryItem(R.drawable.tantalum, "Tantalum"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "Mining Equipment & Mineral Gallery",
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color(0xFF003366),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(items) { item ->
                ProfileGridItem(
                    item = item,
                    navController = navController,
                )
            }
        }
    }
}

@Composable
fun ProfileGridItem(
    item: ProfileGalleryItem,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.8f)
            .clickable {
                val encodedTitle = Uri.encode(item.title)
                navController.navigate("LargeImage/${item.imageRes}/$encodedTitle")
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
