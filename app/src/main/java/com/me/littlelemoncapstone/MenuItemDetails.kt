package com.me.littlelemoncapstone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItemDetails(menuItemRoom: MenuItemRoom) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Row {
            Image(
                modifier = Modifier.fillMaxWidth().padding(
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

        GlideImage(
            model = menuItemRoom.imagerUrl,
            contentDescription = "Dish image",
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.FillWidth
        )

        Column(verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {

            Text(text = menuItemRoom.title, style = MaterialTheme.typography.headlineLarge)
            Text(text = menuItemRoom.description, style = MaterialTheme.typography.bodyLarge)
            Counter()
            Button(modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }) {
                Text(text = "Add For" + " $${menuItemRoom.price}",
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }

        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}