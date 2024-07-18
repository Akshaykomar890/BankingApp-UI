package com.example.bankingapp

import android.content.ClipData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.data.CardItem
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart

val cardItems = listOf(
    CardItem(
        "VISA",
        "Business",
        "756-4554-4545-45",
        45.77,
        gradientColor(PurpleStart, PurpleEnd)
    ),
    CardItem(
        "MASTER CARD",
        "School",
        "856-554-4545",
        100.77,
        gradientColor(BlueStart, BlueEnd)
    ),
    CardItem(
        "VISA",
        "Office",
        "156-454-455-45",
        41.77,
        gradientColor(OrangeStart, OrangeEnd)
    ),
    CardItem(
        "MASTER CARD",
        "Home",
        "7356-4554-4545-45",
        990.77,
        gradientColor(GreenStart, GreenEnd)
    )

)

fun gradientColor(startColor:Color,endColor: Color):Brush{
    return Brush.horizontalGradient(listOf(startColor,endColor))
}


@Preview(showSystemUi = true)
@Composable
fun CardSection(){

    LazyRow(){
        items(cardItems.size){index->
            CardItems(index)

        }

    }

}
@Composable
fun CardItems(index:Int){
    val card = cardItems[index]
    var paddingEnd = 0.dp

    if (index == cardItems.size-1){
        paddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if(card.carType == "MASTER CARD"){
       image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = paddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .clickable { }
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                modifier = Modifier.width(60.dp),
                painter = image,
                contentDescription = card.cardName
            )
            
            Text(
                modifier = Modifier,
                text = card.cardName,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier,
                text = "$ ${card.cardBalance}",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier,
                text = card.cardNumber,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )


        }

    }


}

