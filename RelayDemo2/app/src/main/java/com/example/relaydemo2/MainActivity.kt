package com.example.relaydemo2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.relaydemo2.newscard.NewsCard
import com.example.relaydemo2.newscard.View
import com.example.relaydemo2.ui.theme.RelayDemo2Theme
import com.google.relay.compose.BoxScopeInstance.rowWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RelayDemo2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        NewsCard(
                            thumbnail = painterResource(R.drawable.news_card_thumbnail),
                            headline = "The Wonderful Architectures of This Winter Season",
                            author = "The Seasonal Sagas",
                            date = "August 25, 2021",
                            view = View.HeroItem,
                            modifier = Modifier.rowWeight(1.0f)
                        )

                        Spacer(modifier = Modifier.size(16.dp))

                        NewsCard(
                            thumbnail = painterResource(R.drawable.news_card_thumbnail1),
                            headline = "The New Method to Making Breakfast Crepes",
                            author = "Morning Break",
                            date = "November 10, 2021",
                            view = View.ArticleItem,
                            modifier = Modifier.rowWeight(1.0f)
                        )

                        Spacer(modifier = Modifier.size(16.dp))

                        val context = LocalContext.current
                        NewsCard(
                            thumbnail = painterResource(R.drawable.news_card_thumbnail2),
                            headline = "Wondering Hour: A Childhood Story, Grizzly Bears, and A Sunset in the Distance",
                            author = "The Bees",
                            date = "4 hours ago",
                            view = View.AudioItem,
                            onMenuTapped = {
                                Toast.makeText(context, "Toast at here!", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }
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
    RelayDemo2Theme {
        Greeting("Android")
    }
}