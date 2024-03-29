package com.example.funnumberfacts.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funnumberfacts.ui.theme.FunNumberFactsTheme

@Composable
fun NumberFactButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors()
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(10),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 10.dp),
        colors = colors
    ) {
        Text(
            text = text,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
private fun NumberButtonPreview() {
    FunNumberFactsTheme {
        NumberFactButton(onClick = {}, text = "Click")
    }
}