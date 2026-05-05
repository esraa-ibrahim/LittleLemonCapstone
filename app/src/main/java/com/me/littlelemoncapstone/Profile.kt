package com.me.littlelemoncapstone

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

@Composable
fun Profile(navController: NavHostController) {
    Column {
        Row {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        start = 64.dp,
                        end = 64.dp
                    ),
                painter = painterResource(id = R.drawable.logo),
                contentScale = ContentScale.Fit,
                contentDescription = "App Logo"
            )
        }
        Text(modifier = Modifier.padding(start = 16.dp, top = 32.dp),
            text = "Profile Information",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.green))

        Column(
            modifier = Modifier.weight(1f).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val userData = PreferencesManager.getUserData(LocalContext.current)

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 64.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "First Name",
                    fontSize = 16.sp
                )
                Text(
                    text = userData.firstName,
                    fontSize = 16.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 64.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Last Name",
                    fontSize = 16.sp
                )
                Text(
                    text = userData.lastName,
                    fontSize = 16.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 64.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Email",
                    fontSize = 16.sp
                )
                Text(
                    text = userData.email,
                    fontSize = 16.sp
                )
            }
        }

        val context = LocalContext.current
        Button(
            onClick = {
                PreferencesManager.removeUserData(context)
                navController.navigate(OnBoarding.route) {
                    popUpTo(Home.route) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.yellow),
                contentColor = Color.Black
            ),
            border = BorderStroke(0.5.dp, Color.Black),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Log Out")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    LittleLemonCapstoneTheme {
        //Profile()
    }
}