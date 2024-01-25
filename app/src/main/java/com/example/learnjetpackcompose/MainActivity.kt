package com.example.learnjetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylibrary.CardPreview
import com.example.mylibrary.ColorBox
import com.example.mylibrary.ProfilePreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Greeting(name = "Dinda")
            val painter = painterResource(id = R.drawable.profile)
            val description = "She is brushing her hair"
            val title = "Ms Rabbit"
            val scrollState = rememberScrollState()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.4f)
                        .background(Color.Blue)
                        .padding(20.dp)
                        .padding(top = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProfilePreview(image = painter)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Rabbit", color = Color.White)
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {
                        Intent(applicationContext,
                            NextActivity::class.java)
                            .also { startActivity(it) } }
                    ) {
                        Text(text = "Next Activity", textAlign = TextAlign.Center)
                    }
                }

//                LazyColumn(
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .fillMaxWidth()
//                        .background(Color.White)
//                        .padding(top = 30.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    items(15) {
//                        val i = it + 1;
//                        CardPreview(image = painter, contentDescription = description, title = title + " $i")
//                    }
//                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    itemsIndexed(
                        listOf("Ms Rabbit", "is brushing", "her hair", "late at night", "in her pink room")
                    ){index, title ->
                        val i = index + 1
                        CardPreview(image = painter, contentDescription = description, title = "$i"+ ". "+title)
                    }
                }
            }
        }
    }

    fun startNextActivity(){
        val intent = Intent(this, NextActivity::class.java)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting("Android")
}

