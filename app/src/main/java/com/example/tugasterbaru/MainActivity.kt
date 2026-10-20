package com.example.tugasterbaru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.tugasterbaru.data.Product
import com.example.tugasterbaru.ui.screens.HomeScreen
import com.example.tugasterbaru.ui.screens.OrdersScreen
import com.example.tugasterbaru.ui.screens.ProfileScreen
import com.example.tugasterbaru.ui.theme.TUGASTERBARUTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TUGASTERBARUTheme {
                TUGASTERBARUApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun TUGASTERBARUApp() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.BERANDA) }
    var cartCount by rememberSaveable { mutableIntStateOf(0) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val onAddToCart: (Product) -> Unit = { product ->
        cartCount++
        scope.launch {
            snackbarHostState.showSnackbar(
                message = "${product.name} ditambahkan ke keranjang!",
                duration = SnackbarDuration.Short
            )
        }
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach { destination ->
                item(
                    icon = {
                        if (destination == AppDestinations.BERANDA && cartCount > 0) {
                            BadgedBox(
                                badge = { Badge { Text(cartCount.toString()) } }
                            ) {
                                Icon(
                                    painter = painterResource(destination.icon),
                                    contentDescription = destination.label
                                )
                            }
                        } else {
                            Icon(
                                painter = painterResource(destination.icon),
                                contentDescription = destination.label
                            )
                        }
                    },
                    label = { Text(destination.label) },
                    selected = destination == currentDestination,
                    onClick = { currentDestination = destination }
                )
            }
        }
    ) {
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                when (currentDestination) {
                    AppDestinations.BERANDA -> HomeScreen(onAddToCart = onAddToCart)
                    AppDestinations.PESANAN -> OrdersScreen()
                    AppDestinations.PROFIL -> ProfileScreen()
                }
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    @get:DrawableRes val icon: Int,
) {
    BERANDA("Beranda", R.drawable.ic_home),
    PESANAN("Pesanan", R.drawable.ic_receipt),
    PROFIL("Profil Toko", R.drawable.ic_store),
}

@Preview(showBackground = true)
@Composable
fun TUGASTERBARUAppPreview() {
    TUGASTERBARUTheme {
        TUGASTERBARUApp()
    }
}
