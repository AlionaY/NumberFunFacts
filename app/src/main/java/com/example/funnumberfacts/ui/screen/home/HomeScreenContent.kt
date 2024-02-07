package com.example.funnumberfacts.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.funnumberfacts.R
import com.example.funnumberfacts.ui.component.NumberFactButton
import com.example.funnumberfacts.ui.component.NumberTextField
import com.example.funnumberfacts.ui.theme.FunNumberFactsTheme

@Composable
fun HomeScreenContent(
    text: String,
    isValidInput: Boolean,
    onAction: (HomeScreenAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            NumberTextField(
                text = text,
                isValidInput = isValidInput,
                onNumberEntered = { onAction(HomeScreenAction.OnNumberEntered(it)) },
                onKeyboardAction = { onAction(HomeScreenAction.OnGetNumberFactClick) },
                modifier = Modifier.weight(1f),
            )

            NumberFactButton(
                onClick = { onAction(HomeScreenAction.OnGetNumberFactClick) },
                modifier = Modifier.padding(start = 10.dp, top = 8.dp),
                text = stringResource(id = R.string.get_fact)
            )
        }

        NumberFactButton(
            onClick = { onAction(HomeScreenAction.OnGetRandomNumberFactClick) },
            text = stringResource(id = R.string.get_fact_about_random_number),
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@Preview
@Composable
private fun HomeEmptyInputScreenContentPreview() {
    FunNumberFactsTheme {
        HomeScreenContent(text = "", isValidInput = true, onAction = {})
    }
}

@Preview
@Composable
private fun HomeInvalidInputScreenContentPreview() {
    FunNumberFactsTheme {
        HomeScreenContent(text = "slkjd", isValidInput = false, onAction = {})
    }
}

@Preview
@Composable
private fun HomeValidInputScreenContentPreview() {
    FunNumberFactsTheme {
        HomeScreenContent(text = "111", isValidInput = true, onAction = {})
    }
}