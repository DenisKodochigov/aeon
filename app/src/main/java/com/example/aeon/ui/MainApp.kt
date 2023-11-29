package com.example.aeon.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aeon.navigation.AppNavHost
import com.example.aeon.ui.theme.AppTheme
import com.example.aeon.ui.theme.colorApp
import com.example.aeon.utils.log

@Composable fun MainApp()
{
    AppTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.padding(14.dp).background(color = colorApp.background),
        ){ innerPadding ->
            AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}