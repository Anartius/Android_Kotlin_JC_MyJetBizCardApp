package com.example.myjetbizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetbizcardapp.ui.theme.MyJetBizCardAppTheme
import com.example.myjetbizcardapp.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetBizCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(value = false)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Card(modifier = Modifier
            .width(200.dp)
            .padding(12.dp),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(4.dp)) {

            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfileImage()
                Divider()
                CreateInfo()
                Button(
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PrimaryColor,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape (corner = CornerSize(7.dp)),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value

                    },
                ) {
                    Text(fontSize = 12.sp,
                        text = "Portfolio",
                    )
                }
                if (buttonClickedState.value) Content() else Box {}
            }
        }
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        shadowElevation = 4.dp,
        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Anatoliy C.",
            fontSize = 30.sp,
            color = colorResource(id = R.color.primary_color)
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp),
            color = colorResource(id = R.color.primary_color)
        )
        Text(
            text = "@anatoliy",
            fontSize = 16.sp,
            modifier = Modifier.padding(3.dp),
            color = colorResource(id = R.color.primary_color)
        )
    }
}
@Preview
@Composable
fun Content() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            color = Color.White
        ) {
            Portfolio(data = listOf(
                "Project 1",
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5"
            ))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(4.dp)) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(Color.White)
                ) {
                    CreateProfileImage(modifier = Modifier.size(70.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great Project",
                            fontWeight = FontWeight.W400)
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyJetBizCardAppTheme {
        CreateBizCard()
    }
}