package com.me.littlelemoncapstone

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding() {
    Scaffold()
     { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Row() {
                Image(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 16.dp, start =  64.dp, end = 64.dp), // Maintain 16:9 ratio based on width,
                    painter = painterResource(id = R.drawable.logo),
                    contentScale = ContentScale.Fit,
                    contentDescription = "App Logo"
                )
            }
            Column(
                modifier = Modifier.weight(1f).padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var userFirstName by remember { mutableStateOf("") }
                var userLastName by remember { mutableStateOf("") }
                var userEmail by remember { mutableStateOf("") }

                Text(
                    text = "Let's Get To Know You!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 40.sp,
                    lineHeight = 56.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.green)
                )

                TextField(
                    modifier = Modifier.padding(top = 32.dp),
                    value = userFirstName,
                    maxLines = 1,
                    onValueChange = { value -> userFirstName = value },
                    label = { Text("First name") }
                )

                TextField(
                    modifier = Modifier.padding(top = 32.dp),
                    value = userLastName,
                    maxLines = 1,
                    onValueChange = { value -> userLastName = value },
                    label = { Text("Last name") }
                )

                TextField(
                    modifier = Modifier.padding(top = 32.dp),
                    value = userEmail,
                    maxLines = 1,
                    onValueChange = { value -> userEmail = value },
                    label = { Text("Email") }
                )
            }

            Button(onClick = {},
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
                Text("Register")
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    LittleLemonCapstoneTheme {
        Onboarding()
    }
}