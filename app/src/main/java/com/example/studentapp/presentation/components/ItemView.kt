package com.example.studentapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studentapp.navigation.Screen
import com.example.studentapp.ui.theme.rowBack
import com.example.studentapp.ui.theme.titleColor

@Composable
fun ItemView(navController: NavHostController , title: String,sbNumber:String) {
    Row(
        modifier = Modifier
            .clickable {navController.navigate(Screen.Academics.route+"/$sbNumber") }
            .height(100.dp).padding(20.dp)
            .clip(shape = RoundedCornerShape(topEnd = 35.dp, bottomEnd = 35.dp))
            .background(rowBack)
            .fillMaxWidth()
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(topEnd = 35.dp, bottomEnd = 35.dp),
                color = titleColor
            )
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(
                text = title,
                modifier = Modifier.padding(start = 0.dp, end = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = titleColor, maxLines = 3, overflow = TextOverflow.Ellipsis
            )
        }
    }

}