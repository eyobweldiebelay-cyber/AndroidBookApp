package com.example.passdatajetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class EthiopianMiningSite(
    val no: Int,
    val siteName: String,
    val mineralFound: String,
    val region: String
)

val ethiopianMiningSites = listOf(
    EthiopianMiningSite(1, "Lega Dembi Gold Mine", "Gold", "Oromia"),
    EthiopianMiningSite(2, "Sakaro", "Gold", "Oromia"),
    EthiopianMiningSite(3, "Kenticha Tantalum Mine", "Tantalum", "Oromia"),
    EthiopianMiningSite(4, "Kurmuk", "Gold", "Benishangul-Gumuz"),
    EthiopianMiningSite(5, "Yubdo", "Platinum", "Oromia"),
    EthiopianMiningSite(6, "Bikilal", "Iron ore", "Oromia"),
    EthiopianMiningSite(7, "Danakil Depression", "Potash and salt", "Afar"),
    EthiopianMiningSite(8, "Dallol", "Salt and potash", "Afar"),
    EthiopianMiningSite(9, "Warla", "Opal", "Amhara"),
    EthiopianMiningSite(10, "Shire", "Gold, copper, iron ore, gemstones", "Tigray"),
    EthiopianMiningSite(11, "Menge", "Gold and other minerals", "Benishangul-Gumuz"),
    EthiopianMiningSite(12, "Kurmash", "Marble, coal and other minerals", "Benishangul-Gumuz"),
    EthiopianMiningSite(13, "Abijata–Shalla", "Soda ash", "Oromia"),
    EthiopianMiningSite(14, "Akobo", "Gold and platinum occurrences", "Gambella"),
    EthiopianMiningSite(15, "Arero", "Gold", "Oromia"),
    EthiopianMiningSite(16, "Bule Hora", "Gold", "Oromia")
)

data class EthiopianCoalDeposit(
    val rank: Int,
    val depositName: String,
    val region: String,
    val estimatedReserve: String
)

val ethiopianCoalDeposits = listOf(
    EthiopianCoalDeposit(1, "Geba Basin (Yayu area)", "Oromia", "250 million tonnes"),
    EthiopianCoalDeposit(2, "Delbi–Moye Basin", "Oromia", "41 million tonnes"),
    EthiopianCoalDeposit(3, "Chilga Basin", "Amhara", "20 million tonnes"),
    EthiopianCoalDeposit(4, "Gojeb–Chida–Waka", "Southwestern Ethiopia", "9.5 million tonnes"),
    EthiopianCoalDeposit(5, "Robit–Mersa", "Amhara", "4 million tonnes"),
    EthiopianCoalDeposit(6, "Mush Valley Basin", "Oromia", "0.3 million tonnes")
)

data class EthiopianMiningSoftware(
    val no: Int,
    val softwareName: String,
    val mainUse: String,
    val priority: String
)

val ethiopianMiningSoftwareList = listOf(
    EthiopianMiningSoftware(1, "GEOVIA Surpac", "Geological modelling, mineral resource estimation, and mine design", "Essential"),
    EthiopianMiningSoftware(2, "Deswik", "Mine planning, scheduling, and production planning", "Essential"),
    EthiopianMiningSoftware(3, "Datamine", "Geological data, resource estimation, and mine planning", "Essential"),
    EthiopianMiningSoftware(4, "Micromine", "Mineral exploration, drill-hole data, and geological modelling", "Essential"),
    EthiopianMiningSoftware(5, "Maptek Vulcan", "3D geological modelling and mine design", "Essential"),
    EthiopianMiningSoftware(6, "QGIS", "Geological maps and mineral location mapping", "Essential for beginners"),
    EthiopianMiningSoftware(7, "AutoCAD", "Technical drawings and mine layouts", "Important"),
    EthiopianMiningSoftware(8, "Leapfrog Geo", "3D geological modelling", "Important"),
    EthiopianMiningSoftware(9, "Rocscience Slide2", "Rock slope stability and geotechnical analysis", "Important"),
    EthiopianMiningSoftware(10, "Ventsim DESIGN", "Underground mine ventilation", "Specialized")
)

@Composable
fun DetailScreen(
    name: Array<String>,
    ingredient: Array<String>,
    itemIndex: Int?,
    miningViewModel: MiningViewModel,
    modifier: Modifier = Modifier,
    currentLanguage: String = "English"
) {
    if (itemIndex == null) return

    val currentName = if (itemIndex in name.indices) name[itemIndex] else ""
    val displayName = MiningTranslations.translateName(currentName, currentLanguage)
    val displayDesc = if (itemIndex in ingredient.indices) {
        MiningTranslations.translateDescription(ingredient[itemIndex], currentLanguage)
    } else ""

    val isEthiopianMiningMap = currentName.contains("Map", ignoreCase = true) ||
            currentName.contains("Ethio", ignoreCase = true) ||
            currentName.contains("Major", ignoreCase = true)

    val isCoalDepositsTable = currentName.contains("Coal", ignoreCase = true)
    val isSoftwareTable = currentName.contains("Software", ignoreCase = true)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = displayName,
                color = Color(0xFF003366),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F7FA)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = if (currentLanguage == "Amharic") "ዝርዝር ማብራሪያ" else "Detailed Explanation",
                        color = Color(0xFF003366),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = displayDesc,
                        color = Color.Black,
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }

        if (isSoftwareTable) {
            item {
                EthiopianMiningSoftwareTable(softwareList = ethiopianMiningSoftwareList, currentLanguage = currentLanguage)
            }
        } else if (isCoalDepositsTable) {
            item {
                EthiopianCoalDepositsTable(deposits = ethiopianCoalDeposits, currentLanguage = currentLanguage)
            }
        } else if (isEthiopianMiningMap) {
            item {
                EthiopianMiningSitesTable(sites = ethiopianMiningSites, currentLanguage = currentLanguage)
            }
        }
    }
}

private fun translateRegion(region: String, lang: String): String {
    if (lang != "Amharic") return region
    return when (region) {
        "Oromia" -> "ኦሮሚያ"
        "Amhara" -> "አማራ"
        "Tigray" -> "ትግራይ"
        "Afar" -> "አፋር"
        "Benishangul-Gumuz" -> "ቤንሻንጉል ጉሙዝ"
        "Gambella" -> "ጋምቤላ"
        "Southwestern Ethiopia" -> "ደቡብ ምዕራብ ኢትዮጵያ"
        else -> region
    }
}

@Composable
fun EthiopianMiningSoftwareTable(softwareList: List<EthiopianMiningSoftware>, currentLanguage: String) {
    val tableTitle = if (currentLanguage == "Amharic") "አስፈላጊ የማዕድን ኢንጂነሪንግ ሶፍትዌሮች" else "Essential Mining Engineering Software"
    val noText = if (currentLanguage == "Amharic") "ቁ." else "No."
    val softwareText = if (currentLanguage == "Amharic") "ሶፍትዌር" else "Software"
    val useText = if (currentLanguage == "Amharic") "ዋና አገልግሎት" else "Main use"
    val priorityText = if (currentLanguage == "Amharic") "ቅደም ተከተል" else "Priority"

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = tableTitle,
                color = Color(0xFF003366),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Table Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF003366), RoundedCornerShape(6.dp))
                    .padding(vertical = 10.dp, horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = noText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(0.7f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = softwareText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(2.0f)
                )
                Text(
                    text = useText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(3.0f)
                )
                Text(
                    text = priorityText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(1.8f)
                )
            }

            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

            // Table Data Rows
            softwareList.forEachIndexed { index, software ->
                val rowBg = if (index % 2 == 0) Color(0xFFF8F9FA) else Color.White
                val translatedPriority = if (currentLanguage == "Amharic") {
                    when (software.priority) {
                        "Essential" -> "ძირითადი (Essential)"
                        "Essential for beginners" -> "ለጀማሪዎች አስፈላጊ"
                        "Important" -> "አስፈላጊ (Important)"
                        "Specialized" -> "ልዩ (Specialized)"
                        else -> software.priority
                    }
                } else software.priority

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(rowBg)
                        .padding(vertical = 10.dp, horizontal = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${software.no}",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(0.7f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = software.softwareName,
                        color = Color(0xFF003366),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(2.0f)
                    )
                    Text(
                        text = software.mainUse,
                        color = Color.DarkGray,
                        fontSize = 11.sp,
                        modifier = Modifier.weight(3.0f)
                    )
                    Text(
                        text = translatedPriority,
                        color = Color(0xFF1B5E20),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1.8f)
                    )
                }
                if (index < softwareList.size - 1) {
                    HorizontalDivider(color = Color(0xFFEEEEEE), thickness = 0.5.dp)
                }
            }
        }
    }
}

@Composable
fun EthiopianCoalDepositsTable(deposits: List<EthiopianCoalDeposit>, currentLanguage: String) {
    val tableTitle = if (currentLanguage == "Amharic") "የኢትዮጵያ የድንጋይ ከሰል ተቀማጭ ቦታዎች" else "Coal Deposits in Ethiopia"
    val rankText = if (currentLanguage == "Amharic") "ደረጃ" else "Rank"
    val depositText = if (currentLanguage == "Amharic") "የከሰል ማጠራቀሚያ" else "Coal Deposit"
    val regionText = if (currentLanguage == "Amharic") "ክልል" else "Regional State"
    val reserveText = if (currentLanguage == "Amharic") "ግምታዊ ክምችት" else "Estimated Reserve"

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = tableTitle,
                color = Color(0xFF003366),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Table Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF003366), RoundedCornerShape(6.dp))
                    .padding(vertical = 10.dp, horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = rankText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(0.8f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = depositText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(2.2f)
                )
                Text(
                    text = regionText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(2.0f)
                )
                Text(
                    text = reserveText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(2.0f)
                )
            }

            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

            // Table Data Rows
            deposits.forEachIndexed { index, deposit ->
                val rowBg = if (index % 2 == 0) Color(0xFFF8F9FA) else Color.White
                val translatedRegion = translateRegion(deposit.region, currentLanguage)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(rowBg)
                        .padding(vertical = 10.dp, horizontal = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${deposit.rank}",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(0.8f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = deposit.depositName,
                        color = Color(0xFF003366),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(2.2f)
                    )
                    Text(
                        text = translatedRegion,
                        color = Color(0xFF1B5E20),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(2.0f)
                    )
                    Text(
                        text = deposit.estimatedReserve,
                        color = Color(0xFFC62828),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(2.0f)
                    )
                }
                if (index < deposits.size - 1) {
                    HorizontalDivider(color = Color(0xFFEEEEEE), thickness = 0.5.dp)
                }
            }
        }
    }
}

@Composable
fun EthiopianMiningSitesTable(sites: List<EthiopianMiningSite>, currentLanguage: String) {
    val tableTitle = if (currentLanguage == "Amharic") "በኢትዮጵያ ዋና ዋና የማዕድን ማውጫ አካባቢዎች" else "Major Mining Areas in Ethiopia"
    val noText = if (currentLanguage == "Amharic") "ቁ." else "No."
    val siteText = if (currentLanguage == "Amharic") "የማዕድን ማውጫ" else "Mining Site"
    val mineralText = if (currentLanguage == "Amharic") "የተገኘ ማዕድን" else "Mineral Found"
    val regionText = if (currentLanguage == "Amharic") "ክልል" else "Region"

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = tableTitle,
                color = Color(0xFF003366),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Table Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF003366), RoundedCornerShape(6.dp))
                    .padding(vertical = 10.dp, horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = noText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(0.7f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = siteText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(2.2f)
                )
                Text(
                    text = mineralText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(2.2f)
                )
                Text(
                    text = regionText,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(1.9f)
                )
            }

            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)

            // Table Data Rows
            sites.forEachIndexed { index, site ->
                val rowBg = if (index % 2 == 0) Color(0xFFF8F9FA) else Color.White
                val translatedRegion = translateRegion(site.region, currentLanguage)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(rowBg)
                        .padding(vertical = 10.dp, horizontal = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${site.no}",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(0.7f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = site.siteName,
                        color = Color(0xFF003366),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(2.2f)
                    )
                    Text(
                        text = site.mineralFound,
                        color = Color.DarkGray,
                        fontSize = 12.sp,
                        modifier = Modifier.weight(2.2f)
                    )
                    Text(
                        text = translatedRegion,
                        color = Color(0xFF1B5E20),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1.9f)
                    )
                }
                if (index < sites.size - 1) {
                    HorizontalDivider(color = Color(0xFFEEEEEE), thickness = 0.5.dp)
                }
            }
        }
    }
}
