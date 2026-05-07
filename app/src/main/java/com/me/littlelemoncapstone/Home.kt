package com.me.littlelemoncapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

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

        UpperPanel()
        LowerPanel(navController, menuItems)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LittleLemonCapstoneTheme {
        //Home()
    }
}