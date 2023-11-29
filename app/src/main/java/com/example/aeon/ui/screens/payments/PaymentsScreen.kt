package com.example.aeon.ui.screens.payments

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.aeon.entity.Payment
import com.example.aeon.navigation.ScreenDestination
import com.example.aeon.ui.components.HeaderScreen
import com.example.aeon.ui.components.TextApp
import com.example.aeon.ui.theme.Dimen
import com.example.aeon.ui.theme.colorApp
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date


@Composable
fun  PaymentsScreen(userToken: String, screen: ScreenDestination,)
{
    val viewModel: PaymentViewModel = hiltViewModel()

    PaymentsScreenCreateView(
        screen = screen,
        userToken = userToken,
        viewModel = viewModel,
    )
}
@Composable fun  PaymentsScreenCreateView(
    screen: ScreenDestination,
    userToken: String,
    viewModel: PaymentViewModel
){
    val uiState by viewModel.paymentScreenState.collectAsState()
    if (uiState.request){
        viewModel.getPayments(userToken)
        uiState.request = false
    }
    uiState.idStringScreen = screen.textHeader
    uiState.userToken.value = userToken
    PaymentsScreenLayout( uiState = uiState )
}
@Composable fun  PaymentsScreenLayout( uiState: PaymentsScreenState,
){
    Column {
        Spacer(modifier = Modifier.height(Dimen.paddingElement))
        HeaderScreen(text = stringResource(uiState.idStringScreen) )
        Spacer(modifier = Modifier.height(Dimen.paddingHeaderScreen))
        ListPayment( uiState = uiState )
    }
}

@Composable fun  ListPayment( uiState: PaymentsScreenState,
){
    val listState = rememberLazyListState()
    val listPayments = uiState.payments?.value ?: emptyList()

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .padding(horizontal = Dimen.lazyHor)
    ){
        items(items = listPayments){ item ->
            ItemPayment(item)
        }
    }
}
@SuppressLint("SimpleDateFormat")
@Composable fun  ItemPayment(item: Payment,
){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(6.dp))
            .fillMaxWidth()
            .background(color = colorApp.primaryContainer)
    ) {
        Spacer(modifier = Modifier.width(Dimen.lazyItemStart))
        TextApp(
            text = item.id.toString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 6.dp)
        )

        Spacer(modifier = Modifier.width(Dimen.lazyItemStart))
        TextApp(
            text = SimpleDateFormat("yyyy-MM-dd").format(Date(item.created?.toLong() ?: 0)),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 6.dp)
        )

        Spacer(modifier = Modifier.width(Dimen.lazyItemStart))
        TextApp(
            text = item.title.toString(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 6.dp)
        )

        Spacer(modifier = Modifier.width(Dimen.lazyItemStart).weight(1f))
        TextApp(
            text = item.amount ?: "",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(vertical = 6.dp).width(100.dp)
        )
        Spacer(modifier = Modifier.width(Dimen.lazyItemEnd))
    }
}