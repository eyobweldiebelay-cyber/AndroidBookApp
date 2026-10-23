package com.example.passdatajetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Setting(
    onColorChange: (Color) -> Unit,
    onLanguageChange: (String) -> Unit,
    currentLanguage: String,
    miningViewModel: MiningViewModel,
    modifier: Modifier = Modifier
) {
    val colors = listOf(
        Color.White,
        Color.LightGray,
        Color(0xFFE0F7FA),
        Color(0xFFE8F5E9),
        Color(0xFFFFFDE7)
    )
    val languages = listOf("English", "Amharic")

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = if (currentLanguage == "Amharic") "ቅንጅቶች" else "Settings",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = if (currentLanguage == "Amharic") "ቋንቋ ይምረጡ" else "Select Language",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            languages.forEach { language ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {
                            onLanguageChange(language)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = language == currentLanguage,
                        onClick = {
                            onLanguageChange(language)
                        }
                    )
                    Text(
                        text = if (language == "Amharic") "አማርኛ (Amharic)" else "English",
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = if (currentLanguage == "Amharic") "የስክሪን ቀለም" else "Screen Color",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                colors.forEachIndexed { index, color ->
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(color)
                            .clickable {
                                onColorChange(color)
                            }
                    )
                }
            }
        }
    }
}
