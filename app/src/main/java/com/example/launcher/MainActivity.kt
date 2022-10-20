package com.example.launcher

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.launcher.ui.theme.LauncherTheme
import com.example.launcher.ui.theme.Shapes



private lateinit var packages : List<ApplicationInfo?>
private lateinit var pm : PackageManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        packages = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        pm = this.packageManager
        setContent {
            LauncherTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    displayItem()
                }
            }
        }
    }
}

//PackageManager packageManager = getActivity().getPackageManager();



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun displayItem(){
    var modifier : Modifier = Modifier
    LazyColumn{
        items(packages){item ->

            Card(
                shape = Shapes.medium,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 24.dp)

            ) {

//                val applicationInfo: ApplicationInfo = contex?.getApplicationInfo()

                Text(
                    text = item?.name.toString(),
                    modifier = modifier.padding(vertical = 16.dp, horizontal = 8.dp)
                )
                Log.d("App infomation", "displayItem: ${item?.name}")
            }

        }
    }
}


//get aplication data

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LauncherTheme {
        displayItem()
//        Greeting("Android")
    }
}