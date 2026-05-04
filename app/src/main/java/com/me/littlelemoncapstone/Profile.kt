package com.me.littlelemoncapstone

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

@Composable
fun Profile(navController: NavHostController) {
    Text(text = "Profile")
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    LittleLemonCapstoneTheme {
        //Profile()
    }
}