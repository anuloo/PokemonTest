package com.example.pokemontest.presentation.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TitleBar(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = TextAlign.Center,
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        style = MaterialTheme.typography.h2.copy(
            fontWeight = FontWeight.Bold,
        )
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TitleBarPreview() {
    TitleBar(
        text = "Bar Title",
    )
}