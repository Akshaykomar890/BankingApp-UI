package com.example.bankingapp

import android.graphics.Paint.Align
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.CurrencyItems
import com.example.bankingapp.ui.theme.GreenStart

val currencyList = listOf(
    CurrencyItems(
        "IND",
        79.99f,
        99.56f,
        Icons.Rounded.CurrencyRupee
    ),
    CurrencyItems(
        "USD",
        69.99f,
        99.56f,
        Icons.Rounded.AttachMoney
    ),
    CurrencyItems(
        "EUR",
        89.99f,
        96.56f,
        Icons.Rounded.Euro
    ),
    CurrencyItems(
        "YEN",
        26.99f,
        45.56f,
        Icons.Rounded.CurrencyYen
    ),
    CurrencyItems(
        "USD",
        69.99f,
        99.56f,
        Icons.Rounded.AttachMoney
    ),
    CurrencyItems(
        "EUR",
        89.99f,
        96.56f,
        Icons.Rounded.Euro
    ),
    CurrencyItems(
        "YEN",
        26.99f,
        45.56f,
        Icons.Rounded.CurrencyYen
    )
)

@Preview(showSystemUi = true)
@Composable
fun CurrencySection() {
    val customColor = Color(0xFFF3F4F9)
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        contentAlignment = Alignment.BottomCenter
    )
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = customColor)
                        .clickable {
                            isVisible = !isVisible
                            iconState = if (isVisible) {
                                Icons.Rounded.KeyboardArrowUp
                            } else {
                                Icons.Rounded.KeyboardArrowDown
                            }
                        }
                ) {
                    Icon(imageVector = iconState, contentDescription = null)
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "Currencies",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(customColor)
            )


            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(customColor)
                ) {
                    val boxConstraintScope = this
                    val width = boxConstraintScope.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.width(width),
                                text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                            Text(
                                modifier = Modifier.width(width),
                                text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )

                            Text(
                                modifier = Modifier.width(width),
                                text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )

                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(currencyList.size) { index ->
                                CurrencyView(index, width)
                            }
                        }

                    }

                }
            }

        }
    }

}

@Composable
fun CurrencyView(index: Int,width:Dp) {
    val eachItem = currencyList[index]
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.width(width)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = eachItem.icon, contentDescription = eachItem.name,
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .width(width)
                    .padding(start = 10.dp),
                text = eachItem.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
            )
        }
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$${eachItem.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "$${eachItem.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.End
        )

    }

}

