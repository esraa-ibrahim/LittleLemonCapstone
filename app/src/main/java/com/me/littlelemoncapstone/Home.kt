package com.me.littlelemoncapstone

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

@Composable
fun Home(navController: NavHostController) {
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
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LittleLemonCapstoneTheme {
        //Home()
    }
}