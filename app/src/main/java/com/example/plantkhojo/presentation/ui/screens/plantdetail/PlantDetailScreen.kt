package com.example.plantkhojo.ui.screens.plantdetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.plantkhojo.R


@Preview(showSystemUi = true)
@Composable
fun PlantDetailScreen(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        TopImage()
        Column(modifier = Modifier.padding(20.dp)) {
            Title()
            Description()
            Soil()
            Temperature()
            FavButton()
        }
    }
}

@Composable
fun TopImage(modifier: Modifier = Modifier) {
    // AsyncImage with error handling and loading state monitoring
    Box {
        AsyncImage(
            model = "https://images.unsplash.com/photo-1520412099551-62b6bafeb5bb?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            contentDescription = "Plant Image",
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1.0f),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.img_plant_onboarding),
        )

        // Black gradient overlay
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.0f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.2f), // Light black at top
                            Color.Black.copy(alpha = 0.6f)  // Darker black at bottom
                        )
                    )
                )
        )

        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(40.dp)
                .background(Color.Transparent, MaterialTheme.shapes.medium)
                .border(
                    width = 1.dp,
                    color = colorResource(
                        R.color.offWhite
                    ),
                    shape = MaterialTheme.shapes.medium
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_back_arrow),
                tint =  colorResource(
                    R.color.offWhite
                ),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(18.dp)
            )
        }
    }
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(text = "Guiana Chestnut (Money Tree)",
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(text = "Pachira aquatica",
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun Description(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "Description",
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )

    Spacer(modifier = Modifier.height(2.dp))

    Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun Soil(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "Soil",
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )

    Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun Temperature(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(16.dp))

    Text(text = "Temperature",
        modifier = modifier,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold
    )

    Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Composable
fun FavButton(modifier: Modifier = Modifier) {

    Spacer(modifier = Modifier.height(20.dp))

    Button(onClick = {},
        modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.green_700)
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text("Add To Favourites")
    }
}

