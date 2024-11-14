package terlaluberanganangan.requmi.limung

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import terlaluberanganangan.requmi.limung.ui.theme.LimungTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LimungTheme {

                    Greeting()

            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var deskripsi by remember { mutableIntStateOf(1)}
    when (deskripsi) {
        1 -> R.string.Pohon_lemon
        2 -> R.string.Buah_warna_kuning
        3 -> R.string.Gelas_isi_cairan_kuning
        4 -> R.string.Gelas_bekas_cairan_kuning
        else -> R.string.ada_kesalahan
    }
    var cairanLemon by remember { mutableIntStateOf(1) }
    when (cairanLemon) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable._14675872_1094370505344322_4305499877443606627_n
    }
    var teks by remember {mutableIntStateOf(1)}
    when (teks) {
        1 -> R.string.tap
        2 -> R.string.tapTap
        3 -> R.string.tapTapTap
        4 -> R.string.tapTapTapTap
        else -> R.string.ada_kesalahan
    }
    var perasTeros by remember { mutableIntStateOf(1)}
    when (perasTeros) {
        1 -> {
            deskripsi = 1
            cairanLemon = 1
            teks = 1
        }
        in 2..6 -> {
            deskripsi = 2
            cairanLemon = 2
            teks = 2
        }
        7 -> {
            deskripsi = 3
            cairanLemon = 3
            teks = 3
        }
        8 -> {
            deskripsi = 4
            cairanLemon = 4
            teks = 4
        }
        else -> {
            deskripsi = 5
            cairanLemon = 5
            teks = 5
        }
    }
    Column {
        Text(
            text = "Hello Lemong!",
            modifier = modifier
            )
        Column (
            modifier = modifier
                .weight(5f)
                .fillMaxWidth()
        ){
            Box {
                Button(onClick = { /*TODO*/
                    perasTeros++
                    when (perasTeros) {
                        in 4..6 -> {Random.nextInt(2, 7)}
                    }
                }) {
                    Image (
                        painter = painterResource(cairanLemon),
                        contentDescription = stringResource(deskripsi)
                    )
                }
                Spacer(modifier = modifier.height(16.dp))
                Text(text = stringResource(teks))
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LimungTheme {
        Greeting(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
    }
}