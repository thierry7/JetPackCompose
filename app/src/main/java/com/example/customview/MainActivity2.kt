package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var data : ArrayList<Message> = arrayListOf(Message("interested", "thiery"),
            Message("interested", "thiery"),
            Message("interested", "thiery"),
            Message("interested", "thiery")
        )
        setContent{
//            mytextView(text = "thierry" )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(data) { item ->
                    MessageCard(msg = item)
                }
            }
        }
    }
}

@Composable
fun mytextView(text: String){
    Text(
        text = "Hello $text!",
        color = Color.Blue,

    )
}

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message

        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = msg.author)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.body)
            }
        }

}

@Preview
@Composable
fun mytextViewPreview(){
//    mytextView(text = "thierry")
    var data : ArrayList<Message> = arrayListOf(Message("interested", "thiery"),
        Message("interested", "June"),
        Message("interested", "thiery"),
        Message("interested", "thiery"),
        Message("interested", "thiery"),
        Message("interested", "thiery"),
        Message("interested", "thiery"),
        Message("interested", "thiery")
    )
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(data) { item ->
            MessageCard(msg = item)
        }
    }
}