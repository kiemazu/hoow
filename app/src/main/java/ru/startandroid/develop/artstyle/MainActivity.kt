package ru.startandroid.develop.artstyle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.startandroid.develop.artstyle.ui.theme.ArtStyleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtStyleTheme {
                Scaffold() { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result) {
        1 -> R.drawable.art
        2 -> R.drawable._3567
        3 -> R.drawable.fsfgdsg
        4 -> R.drawable.art
        else -> R.drawable.art
    }
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Column(modifier = modifier.padding(10.dp)) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                modifier = Modifier.size(430.dp)
            )
        }

        Column(
            ) {
            Column() {
                Row(

                ) {
                    Text(
                        text = "Artwork Title",
                        fontSize = 30.sp
                    )
                }
                Row(

                ) {
                    Text(
                        text = "Artwork Artist(Year)"
                    )

                }
            }
        }
        Row(
            modifier = modifier.fillMaxWidth()
                .padding(bottom = 40.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceAround
        ){
            Button(onClick = { result -= 1
                             if (result <= 0){
                                 result = 3

                             }},
                ) {

                Text( text = "Prev")
            }


            Button(onClick = {result += 1
            if (result > 3){
                result = 1

            }}) {
                Text(text = "Next")
            }


        }


    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtStyleTheme {
        Greeting()
    }
}