package com.me.littlelemoncapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme
import com.me.littlelemoncapstone.ui.theme.Typography

@Composable
fun Home(navController: NavHostController, menuItems: List<MenuItemRoom>) {
    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .weight(0.7f)
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 64.dp,
                    ),
                painter = painterResource(id = R.drawable.logo),
                contentScale = ContentScale.Fit,
                contentDescription = "App Logo"
            )

            Image(
                modifier = Modifier
                    .weight(0.3f)
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 32.dp,
                        end = 32.dp
                    )
                    .clickable {
                        navController.navigate(Profile.route)
                    },
                painter = painterResource(id = R.drawable.profile),
                contentScale = ContentScale.Fit,
                contentDescription = "Profile Image",
            )
        }

        MyHomeScreen(navController, menuItems)
    }
}

@Composable
fun MyHomeScreen(navController: NavHostController,
                 menuItems: List<MenuItemRoom>,
                 modifier: Modifier = Modifier) {
    var searchPhrase by remember { mutableStateOf("") }
    var filteredMenuItems by remember { mutableStateOf(emptyList<MenuItemRoom>()) }
    Column(Modifier.background(Color(0xFF495E57)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        RestaurantName(modifier)
        RestaurantLocation(modifier)
        Row(Modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically ) {
            RestaurantDescription(modifier)

            Image(painterResource(R.drawable.hero_image),
                contentDescription = "Restaurant Food",
                modifier = Modifier
                    .size(150.dp) // Or any desired size
                    .aspectRatio(1f).clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.FillBounds)
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, bottom = 20.dp, end = 20.dp),
            value = searchPhrase,
            maxLines = 1,
            shape = RoundedCornerShape(12.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = "Search Icon"
                )
            },
            onValueChange = { value -> searchPhrase = value },
            placeholder = { Text(text = "Enter Search Phrase") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedLabelColor = Color.Black
            )
        )
    }
    Column {
        WeeklySpecialCard()

        val categories = menuItems.map {
            it.category
                .replaceFirstChar { firstChar ->
                    firstChar.titlecase()
                }
        }.distinct()

        Row(
            modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            categories.forEach { category ->
                MenuCategory(category, {
                    filteredMenuItems = menuItems.filter { it.category == category.lowercase() }
                })
            }
        }

        filteredMenuItems = if (searchPhrase.isNotBlank()) {
            menuItems.filter { it.title.contains(searchPhrase, true) }
        } else {
            menuItems
        }

        LazyColumn {
            itemsIndexed(filteredMenuItems) { _, menuItem ->
                MenuItems(navController, menuItem)
            }
        }
    }
}

@Composable
fun RestaurantDescription(modifier: Modifier) {
    Text(
        text = stringResource(R.string.description),
        fontSize = 18.sp,
        modifier = modifier.padding(bottom = 20.dp).fillMaxWidth(0.6f),
        color = Color.White
    )
}

@Composable
fun RestaurantName(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.title),
        fontSize = 32.sp,
        color = Color(0xFFF4CE14),
        modifier = modifier.padding(start = 20.dp, top = 20.dp)
    )
}

@Composable
private fun RestaurantLocation(
    modifier: Modifier
) {
    Text(
        text = stringResource(R.string.location),
        fontSize = 24.sp,
        color = Color(0xFFFFFFFF),
        modifier = modifier.padding(start = 20.dp)
    )
}

@Composable
fun MenuCategory(category: String, onCategoryClicked: () -> Unit) {
    Button(onClick = {
        onCategoryClicked()
    },
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
fun MenuItems(navController: NavHostController? = null, menuItem: MenuItemRoom) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {
            navController?.navigate(menuItem)
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
                contentDescription = "Menu Item Image"
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = colorResource(R.color.yellow)
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LittleLemonCapstoneTheme {
        //Home()
    }
}