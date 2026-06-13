package com.sumberilmu.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.sumberilmu.app.ui.SumberIlmuApp
import com.sumberilmu.app.ui.theme.SumberIlmuTheme

class MainActivity : ComponentActivity() {

    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SumberIlmuTheme {
                SumberIlmuApp(appViewModel)
            }
        }
    }
}
