package com.gdsc_core_tripathi.festivals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
private fun ItemsUI(message: Message){

    Card(elevation = 5.dp ,
    modifier = Modifier
        .fillMaxWidth()
        .padding(start = 5.dp,
                end = 5.dp,
                top = 5.dp
        )
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(painter = painterResource(id = message.profileImage),
                contentDescription =null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(CircleShape),
            contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier
                .padding(start = 16.dp)) {


                Text(text = message.name,
                    fontWeight = FontWeight.Bold)
                Text(text = message.message)
            }
        }

    }

}

@Composable
fun MyRecyclerView(messages:List<Message>){
    LazyColumn{
        items(messages){myMessage ->
    ItemsUI(message = myMessage)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyPrev(){
    val sms = remember {
        MyRepository().getAllMessages()
    }
    MyRecyclerView(messages = sms)
}