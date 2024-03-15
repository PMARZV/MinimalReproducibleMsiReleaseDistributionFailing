import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "KotlinProject") {
        MaterialTheme {
            Scaffold {
                LazyVerticalGrid(columns = GridCells.Adaptive(400.dp), modifier = Modifier.fillMaxSize()) {
                    items(100){
                        KamelImage(
                            asyncPainterResource("https://media.giphy.com/media/3ornjIhZGFWpbcGMAU/giphy.gif?cid=790b7611won83la9d3vl8gl5si15iy9h94z43m1li9r8zqi0&ep=v1_gifs_search&rid=giphy.gif&ct=g"),
                            contentDescription = "Compose",
                            modifier = Modifier.fillMaxSize().aspectRatio(1f),
                            onFailure = { Box(modifier = Modifier.fillMaxSize().aspectRatio(1f).background(Color.Red)) },
                            onLoading = {
                                Box(modifier = Modifier.fillMaxSize().aspectRatio(1f).background(Color.Gray).border(1.dp, Color.Black)){
                                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

                                }
                                println(it)
                            })

                    }



                }


            }
        }
    }
}