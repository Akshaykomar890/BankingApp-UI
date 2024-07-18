package com.example.bankingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.StarHalf
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AccountBalanceWallet
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.FinanceItems
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleStart

val financeList = listOf(
    FinanceItems(
        "My\nBusiness",
        Icons.AutoMirrored.Rounded.StarHalf,
        OrangeStart
    ),
    FinanceItems(
        "My\nWallet",
        Icons.Rounded.AccountBalanceWallet,
        BlueStart
    ),
    FinanceItems(
        "My\nAnalysis",
        Icons.Rounded.AccountBalance,
        PurpleStart
    ),
    FinanceItems(
        "My\nTransitions",
        Icons.Rounded.MonetizationOn,
        GreenStart
    )
)

@Preview(showSystemUi = true)
@Composable
fun FinanceSection(){
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )
    }
    LazyRow{
        items(financeList.size){index ->
            FinanceCard(index)
        }
    }
}

@Composable
fun FinanceCard(index:Int) {
    val eachItem = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(25.dp))
                .clickable { }
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(eachItem.background)
                    .padding(5.dp)

            ) {
                Icon(
                    imageVector = eachItem.icon, contentDescription = eachItem.name,
                    tint = Color.White
                )
            }

            Text(
                text = eachItem.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )


        }
    }
}