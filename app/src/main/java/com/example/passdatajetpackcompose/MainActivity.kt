package com.example.passdatajetpackcompose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.passdatajetpackcompose.ui.theme.MiningBookTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiningBookTheme {
                val miningViewModel: MiningViewModel = viewModel()
                val name = arrayOf(
                    "Major mining areas in Ethiopia",
                    "Ore",
                    "Mineral",
                    "Vein",
                    "Outcrop",
                    "Grade",
                    "Assay",
                    "Waste",
                    "Overburden",
                    "Bedrock",
                    "Anomaly",
                    "Core Sample",
                    "Stripping Ratio",
                    "Cut-off Grade",
                    "Tailings",
                    "Host Rock",
                    "Lode",
                    "Placer",
                    "Reclamation",
                    "Seam",
                    "Strike",
                    "Open-Pit",
                    "Bench",
                    "Berm",
                    "Pit Wall",
                    "Haul Road",
                    "Highwall",
                    "Quarry",
                    "Dragline",
                    "Blast Hole",
                    "Face",
                    "Stockpile",
                    "Alluvial Mining",
                    "Backfill",
                    "Bucket-Wheel Excavator",
                    "Crest",
                    "Toe",
                    "Angle of Repose",
                    "Slope Stability",
                    "Cast Blasting",
                    "Scaling",
                    "Adit",
                    "Shaft",
                    "Portal",
                    "Drift",
                    "Crosscut",
                    "Stope",
                    "Pillar",
                    "Sump",
                    "Winze",
                    "Raise",
                    "Cage",
                    "Headframe",
                    "Decline",
                    "Longwall Mining",
                    "Room and Pillar",
                    "Sublevel Caving",
                    "Rock Bolt",
                    "Ventilation",
                    "Dredging",
                    "Grizzly",
                    "Crusher",
                    "Ball Mill",
                    "Froth Flotation",
                    "Leaching",
                    "Concentrate",
                    "Smelting",
                    "Refining",
                    "Comminution",
                    "Gravity Separation",
                    "Slurry",
                    "Thickener",
                    "Cyanidation",
                    "Electrowinning",
                    "Fines",
                    "Recovery",
                    "Pulp",
                    "Sieve",
                    "Magnetic Separation",
                    "Roasting",
                    "Beneficiation",
                    "Feasibility Study",
                    "Life of Mine (LOM)",
                    "Capex",
                    "Opex",
                    "PPE",
                    "MSDS",
                    "In-Situ",
                    "Subsidence",
                    "Dilution",
                    "Bulk Mining",
                    "Selective Mining",
                    "ANFO",
                    "Detonator",
                    "Muck",
                    "Load-Haul-Dump (LHD)",
                    "EIA",
                    "Reserve",
                    "Resource",
                    "Trommel",
                    "NSR",
                    "Belt Conveyor",
                    "Scrapers",
                    "Dumper",
                    "Bentonite",
                    "Chrome or Chromite",
                    "Clay",
                    "Copper",
                    "Diatomite",
                    "Emerald",
                    "Gold",
                    "Gypsum",
                    "Halite",
                    "Laterite Iron Ore",
                    "Lignite",
                    "Limestone",
                    "Manganese",
                    "Nickel",
                    "Niobium",
                    "Oil and Gas",
                    "Platinum",
                    "Oil Shale",
                    "Perlite",
                    "Potash",
                    "Sandstone",
                    "Tantalum",
                    "Coal deposits in Ethiopia",
                    "Essential Mining Engineering software"
                )
                val ingradent = arrayOf(
                    "Geological survey map detailing major mineral deposit locations, regional state sites, and active mining areas in Ethiopia.",
                    "A rock deposit that contains enough mineral to be mined at a profit.",
                    "A naturally occurring inorganic substance with a definite chemical composition.",
                    "A distinct sheet-like body of crystallized minerals within a rock.",
                    "Part of a rock formation that appears at the surface of the ground.",
                    "The concentration of each valuable metal within an ore.",
                    "A chemical test to determine the metal content of a sample.",
                    "Rock that lacks enough mineral to be mined profitably.",
                    "The soil and rock sitting on top of an ore body that must be removed.",
                    "Solid rock that underlies soil and other unconsolidated material.",
                    "A geological feature that differs from the surrounding area (potential mine site).",
                    "A cylindrical sample of rock obtained by drilling.",
                    "The unit of waste removed per unit of ore mined.",
                    "The minimum grade required for a mineral or metal to be economically mined.",
                    "The materials left over after the process of separating the valuable fraction from the uneconomic fraction.",
                    "The rock surrounding an ore deposit.",
                    "A mineral deposit that fills a crack in a rock formation.",
                    "A deposit of sand or gravel containing gold or other heavy minerals.",
                    "Restoring the land to a natural or usable state after mining.",
                    "A layer of ore (usually used for Coal or Potash).",
                    "The direction of a horizontal line on an inclined rock layer.",
                    "A surface mine open to the sky (used for massive deposits).",
                    "A horizontal step or floor in an open pit to maintain stability.",
                    "A horizontal shelf built into a slope to stop falling rocks.",
                    "The side of the open-pit excavation.",
                    "A road constructed for heavy mining trucks.",
                    "The unexcavated face of exposed overburden and coal in a surface mine.",
                    "A surface mine for building materials like granite or limestone.",
                    "A large excavating machine that pulls a bucket toward itself via cables.",
                    "A hole drilled into rock to hold explosives.",
                    "The exposed surface of the ore where mining is currently happening.",
                    "A pile of ore or waste stored for future use or processing.",
                    "Mining minerals from riverbeds or floodplains.",
                    "Waste rock used to fill an empty mine cavity.",
                    "A continuous mining machine for soft materials.",
                    "The top edge of a bench.",
                    "The bottom edge of a bench.",
                    "The steepest angle at which loose material remains stable.",
                    "The resistance of an inclined surface to failure (landslides).",
                    "Using explosives to move overburden directly into a void.",
                    "Removing loose rocks from a highwall or ceiling for safety.",
                    "A horizontal entrance to an underground mine.",
                    "A vertical or near-vertical opening for moving men and equipment.",
                    "The entrance to a tunnel or adit.",
                    "A horizontal tunnel that follows a vein.",
                    "A horizontal tunnel that cuts across the ore body.",
                    "The actual excavation room where ore is extracted underground.",
                    "A block of ore left in place to support the roof.",
                    "The lowest point in a mine where water collects to be pumped out.",
                    "A vertical connection between levels (drilled downward).",
                    "A vertical connection between levels (drilled upward).",
                    "The elevator used to transport miners in a shaft.",
                    "The structure above a shaft that holds the hoisting machinery.",
                    "A slanted tunnel (ramp) used for vehicle access.",
                    "A continuous form of underground coal mining.",
                    "A mining method where rooms are cut out, leaving pillars for support.",
                    "A method where ore is blasted and allowed to collapse into a tunnel.",
                    "A long bolt used to anchor loose rock to solid rock in the ceiling.",
                    "The system for providing fresh air to underground workers.",
                    "Excavating materials from underwater.",
                    "A heavy metal grate used to screen large rocks.",
                    "A machine that breaks large rocks into smaller pieces.",
                    "A rotating drum with steel balls used to grind ore into powder.",
                    "A process using bubbles to separate minerals from waste.",
                    "Using chemicals (like cyanide or acid) to dissolve minerals from rock.",
                    "The product of a processing plant containing the valuable mineral.",
                    "Heating ore to melt and separate the pure metal.",
                    "The final purification of a metal.",
                    "The process of reducing rock size (crushing and grinding).",
                    "Separating minerals based on their density.",
                    "A mixture of crushed ore and water.",
                    "A tank where water is removed from slurry.",
                    "Extracting gold by dissolving it in a cyanide solution.",
                    "Using electricity to recover metal from a solution.",
                    "Very small particles of ore or rock.",
                    "The percentage of metal actually extracted compared to what was in the rock.",
                    "Crushed ore mixed with water for processing.",
                    "A screen used to size ore particles.",
                    "Using magnets to pull iron-bearing minerals from ore.",
                    "Heating ore in air to cause a chemical reaction (usually for sulfur).",
                    "Improving the chemical or physical properties of an ore.",
                    "An evaluation to see if a mine will be profitable.",
                    "The expected duration of mining at a specific site.",
                    "Capital Expenditure (cost of building the mine/buying equipment).",
                    "Operating Expenditure (daily cost of running the mine).",
                    "Personal Protective Equipment (hard hats, boots, etc.).",
                    "Material Safety Data Sheet (info on chemicals).",
                    "Minerals in their original place in the ground.",
                    "The sinking of the ground surface due to underground mining.",
                    "Waste rock that gets mixed in with the ore during mining.",
                    "Large-scale mining of low-grade ore.",
                    "Carefully mining only the high-grade sections.",
                    "A common explosive (Ammonium Nitrate/Fuel Oil).",
                    "A device used to set off an explosion.",
                    "The blasted rock ready to be loaded.",
                    "A specialized low-profile loader for underground use.",
                    "Environmental Impact Assessment.",
                    "Part of a resource that is legally and economically mineable.",
                    "A concentration of minerals that might become a reserve.",
                    "A rotating screened cylinder for sizing ore.",
                    "Net Smelter Return (the amount the mine receives after processing costs).",
                    "System to transport mined material efficiently over long distances.",
                    "Equipment used for earthmoving and surface excavation.",
                    "Large truck used for transporting mined materials.",
                    "Absorbent aluminum phyllosilicate clay used in drilling mud.",
                    "An iron chromium oxide mineral used in metallurgy.",
                    "Fine-grained natural rock or soil material.",
                    "Ductile metal with high thermal and electrical conductivity.",
                    "Naturally occurring, soft, siliceous sedimentary rock.",
                    "Gemstone and a variety of the mineral beryl.",
                    "Precious metal used in jewelry and industry.",
                    "Soft sulfate mineral composed of calcium sulfate dihydrate.",
                    "Mineral form of sodium chloride (rock salt).",
                    "Iron-rich weathered rock product used as iron ore.",
                    "Soft brown coal with high moisture content.",
                    "Sedimentary rock composed mainly of calcium carbonate.",
                    "Hard, brittle element used in steel production.",
                    "Silvery-white lustrous metal with a slight golden tinge.",
                    "Light grey, crystalline, and ductile transition metal.",
                    "Fossil fuels found underground in geological formations.",
                    "Dense, malleable, ductile, highly unreactive transition metal.",
                    "Fine-grained sedimentary rock containing kerogen.",
                    "An amorphous volcanic glass with high water content.",
                    "Varieties of mined and manufactured salts containing potassium.",
                    "Clastic sedimentary rock composed mainly of sand-sized minerals.",
                    "Rare, hard, blue-gray, lustrous transition metal.",
                    "Comprehensive geological survey table detailing coal basin deposits, regional states, and estimated reserves in Ethiopia.",
                    "Comprehensive geological survey table detailing essential mining engineering software, their primary uses, and priorities."
                )
                LearDrawerNav(name = name, ingradent = ingradent, miningViewModel = miningViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearDrawerNav(
    name: Array<String>,
    ingradent: Array<String>,
    miningViewModel: MiningViewModel
) {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current

    var currentLanguage by remember { mutableStateOf("English") }
    var screenColor by remember { mutableStateOf(Color.White) }
    var searchQuery by remember { mutableStateOf("") }
    var isSearchExpanded by remember { mutableStateOf(false) }

    val customBarColor = Color(0xFF003366)
    val iconColor = Color.White

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier.fillMaxWidth().height(20.dp))
                NavigationDrawerItem(
                    label = { Text(text = if (currentLanguage == "Amharic") "መነሻ" else "Home", color = Color.Magenta) },
                    selected = true,
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(navigationController.graph.startDestinationId) {
                                inclusive = false
                            }
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = if (currentLanguage == "Amharic") "ቅንጅቶች" else "Setting", color = Color.Magenta) },
                    selected = false,
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Setting.screen)
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = if (currentLanguage == "Amharic") "መገለጫ" else "Gallery", color = Color.Black) },
                    selected = false,
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Profile.screen)
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = if (currentLanguage == "Amharic") "ውጣ" else "Log out", color = Color.Magenta) },
                    selected = false,
                    onClick = {
                        val label = if (currentLanguage == "Amharic") "ውጣ" else "Log out"
                        coroutineScope.launch { drawerState.close() }
                        Toast.makeText(context, label, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        if (isSearchExpanded) {
                            TextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(
                                        text = if (currentLanguage == "Amharic") "ርዕስ ፈልግ..." else "Search by title...",
                                        color = Color.White.copy(alpha = 0.7f)
                                    )
                                },
                                colors = TextFieldDefaults.colors(
                                    focusedTextColor = Color.White,
                                    unfocusedTextColor = Color.White,
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    cursorColor = Color.White
                                )
                            )
                        } else {
                            Text("MiningBook")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu", tint = iconColor)
                        }
                    },
                    actions = {
                        if (isSearchExpanded) {
                            IconButton(onClick = {
                                isSearchExpanded = false
                                searchQuery = ""
                            }) {
                                Icon(Icons.Default.Close, contentDescription = "Close search", tint = iconColor)
                            }
                        } else {
                            IconButton(onClick = {
                                currentLanguage = if (currentLanguage == "English") "Amharic" else "English"
                            }) {
                                Icon(Icons.Default.Language, contentDescription = "Switch Language", tint = iconColor)
                            }
                            IconButton(onClick = {
                                isSearchExpanded = true
                            }) {
                                Icon(Icons.Default.Search, contentDescription = "Search", tint = iconColor)
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = customBarColor,
                        titleContentColor = iconColor,
                        actionIconContentColor = iconColor,
                        navigationIconContentColor = iconColor
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = customBarColor,
                    contentColor = iconColor
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Check out this Mining Terminology guide!")
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }) {
                        Icon(Icons.Default.Share, contentDescription = "Share", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        val packageName = context.packageName
                        try {
                            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                        } catch (_: Exception) {
                            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                        }
                    }) {
                        Icon(Icons.Default.Star, contentDescription = "Rate", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = {
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(navigationController.graph.startDestinationId) {
                                inclusive = false
                            }
                        }
                    }) {
                        Icon(Icons.Default.Home, contentDescription = "Home", tint = iconColor)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(screenColor)
            ) {
                NavHost(
                    navController = navigationController,
                    startDestination = Screens.Home.screen
                ) {
                    composable(Screens.Home.screen) {
                        MainScreen(
                            name = name,
                            ingradent = ingradent,
                            navController = navigationController,
                            searchQuery = searchQuery
                        )
                    }
                    composable(
                        route = Screens.LargeImage.screen,
                        arguments = listOf(
                            navArgument("imageRes") { type = NavType.IntType },
                            navArgument("title") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0
                        val title = backStackEntry.arguments?.getString("title") ?: ""
                        LargeImageSize(
                            imageRes = imageRes,
                            title = title,
                            navController = navigationController
                        )
                    }
                    composable(Screens.Profile.screen) {
                        Profile(
                            miningViewModel = miningViewModel,
                            navController = navigationController
                        )
                    }
                    composable(Screens.Setting.screen) {
                        Setting(
                            onColorChange = { screenColor = it },
                            onLanguageChange = { currentLanguage = it },
                            currentLanguage = currentLanguage,
                            miningViewModel = miningViewModel
                        )
                    }
                    composable(
                        route = "DetailScreen/{index}",
                        arguments = listOf(
                            navArgument("index") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val index = backStackEntry.arguments?.getInt("index")
                        DetailScreen(
                            name = name,
                            ingredient = ingradent,
                            itemIndex = index,
                            miningViewModel = miningViewModel
                        )
                    }
                }
            }
        }
    }
}
