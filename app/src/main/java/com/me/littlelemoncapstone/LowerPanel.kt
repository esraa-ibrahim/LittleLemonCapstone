package com.me.littlelemoncapstone

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.me.littlelemoncapstone.ui.theme.Typography

@Composable
fun LowerPanel(navController: NavHostController, menuItems: List<MenuItemRoom> = listOf()) {
    Column {
        WeeklySpecialCard()

        val categories = menuItems.map { it.category }.distinct()
        Row(modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            categories.forEach { category ->
                MenuCategory(category)
            }
        }

        LazyColumn {
            itemsIndexed(menuItems) { _, menuItem ->
                MenuDish(navController, menuItem)
            }
        }
    }
}

@Composable
fun MenuCategory(category: String, modifier: Modifier = Modifier) {
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEDEFEE)),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(text = category)
    }
}

@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Text(
            text = "Order For Delivery!",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, menuItem: MenuItemRoom) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            // TODO Implement dish details screen and navigate to it on click
            //navController?.navigate(DishDetails.route + "/${dish.id}")
        }) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column() {
                Text(
                    text = menuItem.title,
                    fontSize = 18.sp,
                    style = Typography.headlineMedium
                )

                Text(
                    text = menuItem.description,
                    Modifier
                        .fillMaxWidth(0.75f)
                        .padding(top = 5.dp, bottom = 5.dp),
                    fontSize = 18.sp,
                    style = Typography.bodyLarge,
                    color = Color.Gray
                )

                Text(
                    text = "$${menuItem.price}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    style = Typography.bodyMedium,
                    color = Color.Gray
                )
            }
            GlideImage(
                model = menuItem.imagerUrl,
                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                contentDescription = "Greek Salad Image"
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = colorResource(R.color.yellow)
    )
}