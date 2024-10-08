package cz.ctu.fit.bi.and.parizmat.semestral.core.presentation.ui

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import cz.ctu.fit.bi.and.parizmat.semestral.R

@Composable
fun ErrorScreen(text: String = stringResource(R.string.something_gone_wrong)) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.error),
            contentDescription = stringResource(id = R.string.error),
            modifier = Modifier.size(240.dp),
            tint = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            color = MaterialTheme.colorScheme.onPrimary,
            text = text
        )
    }
}