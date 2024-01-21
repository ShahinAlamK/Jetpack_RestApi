import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.testapp.data.models.Article

@Composable
fun NewsCard(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Box (
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            ){
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    model = "${article.urlToImage}",
                    contentDescription = null,
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 6.dp)
            ) {
                Text(text = "${article.title}", maxLines = 2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "${article.description}", maxLines = 3, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }

}