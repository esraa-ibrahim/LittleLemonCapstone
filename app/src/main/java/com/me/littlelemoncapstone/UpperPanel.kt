package com.me.littlelemoncapstone

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.me.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

@Composable
fun UpperPanel(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(Modifier.background(Color(0xFF495E57)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        RestaurantName(modifier)
        RestaurantLocation(modifier)
        Row(Modifier.fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Pushes items to the far left and right
            verticalAlignment = Alignment.CenterVertically ) {
            RestaurantDescription(modifier)

            Image(painterResource(R.drawable.hero_image),
                contentDescription = "Restaurant Food",
                modifier = Modifier
                    .size(150.dp) // Or any desired size
                    .aspectRatio(1f).clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.FillBounds)
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

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    LittleLemonCapstoneTheme {
        UpperPanel( )
    }
}