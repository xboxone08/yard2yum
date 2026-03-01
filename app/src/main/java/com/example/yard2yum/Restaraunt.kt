package com.example.yard2yum

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.yard2yum.ui.theme.Yard2yumTheme

class Restaurant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF06402B)),
                containerColor = Color(0xFF06402B)
            ) { innerPadding ->
                Hello(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun Hello(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var restaurantType by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
    Text(
        text = "Upload your Logo",
        color = Color(0xFFFFFFFF),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.offset(x = 115.dp, y = 240.dp)
    )
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Restaurant Name input
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Restaurant Name", color = Color.White) },
            modifier = Modifier
                .width(200.dp)
                .heightIn(min = 56.dp)
                .offset(x = 105.dp, y = 420.dp)
        )

        // Restaurant Type input
        OutlinedTextField(
            value = restaurantType,
            onValueChange = { restaurantType = it },
            label = { Text("Restaurant Type", color = Color.White) },
            modifier = Modifier
                .width(200.dp)
                .heightIn(min = 56.dp)
                .offset(x = 105.dp, y = 500.dp)
        )

        // Image upload button
        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(x = 160.dp, y = 280.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF0F6B55))
                .border(2.dp, Color.White, RoundedCornerShape(12.dp))
                .clickable { launcher.launch("image/*") },
            contentAlignment = Alignment.Center
        ) {
            if (imageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "Selected Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text(
                    text = "+",
                    color = Color.White,
                    fontSize = 36.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Yard2yumTheme {
        Hello()
    }
}