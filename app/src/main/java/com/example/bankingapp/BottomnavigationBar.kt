package com.example.bankingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingapp.data.BottomNavigationItem

val navItems = listOf(
    BottomNavigationItem(
        "Home",
        Icons.Filled.Home,
        Icons.Outlined.Home
    ),
    BottomNavigationItem(
        "Wallet",
        Icons.Filled.Wallet,
        Icons.Outlined.Wallet
    ),
    BottomNavigationItem(
        "Notification",
        Icons.Filled.Notifications,
        Icons.Outlined.Notifications
    ),
    BottomNavigationItem(
        "Account",
        Icons.Filled.AccountCircle,
        Icons.Outlined.AccountCircle
    ),
)

@Preview(showSystemUi = true)
@Composable
fun BottomnavigationBar(
){
    var selected by remember {
        mutableIntStateOf(0)
    }
    NavigationBar(modifier = Modifier.clip(RoundedCornerShape(20.dp))) {
        val customColor = Color(0xFFF3F4F9)
        Row(modifier = Modifier.background(color = customColor)) {
            navItems.forEachIndexed { index, bottomNavigationItem ->
                NavigationBarItem(
                    selected = index==selected ,
                    onClick = {
                             selected = index
                    },
                    icon = {
                       if (selected == index){
                           Icon(imageVector = bottomNavigationItem.filledIcon,
                               contentDescription = bottomNavigationItem.name, tint = MaterialTheme.colorScheme.onBackground)
                       }
                        else{
                           Icon(imageVector = bottomNavigationItem.unfilledIcon,
                               contentDescription = bottomNavigationItem.name, tint = MaterialTheme.colorScheme.onBackground)
                       }
                    },
                    label = {
                        Text(text = bottomNavigationItem.name,
                            fontWeight = FontWeight.SemiBold
                            )
                    }
                )
            }

        }
    }
}