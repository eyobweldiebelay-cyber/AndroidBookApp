package com.example.passdatajetpackcompose

sealed class Screens(val screen: String) {
    object Home : Screens("Home")
    object Profile : Screens("Profile")
    object Setting : Screens("Setting")
    object LargeImage : Screens("LargeImage/{imageRes}/{title}")
}
