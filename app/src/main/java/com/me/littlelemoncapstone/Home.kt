package com.me.littlelemoncapstone

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

@Composable
fun Home(navController: NavHostController) {
    Text(text = "Home")
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    LittleLemonCapstoneTheme {
        //Home()
    }
}