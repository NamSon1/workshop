package com.example.wsnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wsnavigation.ui.theme.WSNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WSNavigationTheme {
                    //Erstellung des NavControllers
                    val navController = rememberNavController()

                    //Erstellung des NavHosts und Destinations
                    NavHost(navController = navController, startDestination = "home"){
                        composable("home"){
                            HomeScreen(navController)
                        }

                        composable("profile"){
                            ProfileScreen(navController)
                        }

                        composable("detail"){
                            DetailScreen(navController)
                        }
                    }
            }
        }
    }
}

//Screen Composable
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Home Screen", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        //Weiterleitung zum ProfileScreen
        Button(
            onClick = {
                navController.navigate("profile")
            }) {
                Text(text = "Go to ProfileScreen")
            //Icon(imageVector = ImageVector.vectorResource(id = R.drawable.arrowback), contentDescription = null)
        }

    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Profile Screen", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        //Weiterleitung zum DetailScreen
        Button(
            onClick = {
                //navController.popBackStack()
                navController.navigate("detail")
            }) {
            Text(text = "Go to DetailScreen")
        }

        //Button mit selbst eingefügtem Icon
        //Zurückleitung zum vorherigen Screen
        IconButton(
            onClick = {
                navController.popBackStack()
            }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.arrowback), contentDescription = "Back-Button")
        }
    }
}


@Composable
fun DetailScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Detail Screen", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(16.dp))

        //ein Eintrag vom Backstack wird entfernt --> Weiterleitung zum vorherigen Screen (Profilscreen)
        Button(
            onClick = {
                navController.popBackStack()
            }) {
            Text(text = "Go Back")
        }
    }
}






