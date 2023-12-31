package com.example.aeon.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.aeon.entity.Authorization
import com.example.aeon.navigation.AppNavHost
import com.example.aeon.ui.theme.AppTheme
import com.example.aeon.ui.theme.colorApp

@Composable fun MainApp()
{
    Authorization.clear()

    AppTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.padding(14.dp).background(color = colorApp.background),
        ){ innerPadding ->
            AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}