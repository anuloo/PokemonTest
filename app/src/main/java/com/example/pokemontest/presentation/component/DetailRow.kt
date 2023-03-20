package com.example.pokemontest.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DetailRow(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = TextAlign.Start,
) {
    Row(
    ) {
        Text(
            text = title,
            modifier = modifier,
            textAlign = textAlign,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
            )
        )
        Spacer(modifier = modifier.requiredSize(20.dp))
        Text(
            text = value,
            modifier = modifier,
            textAlign = textAlign,
            style = MaterialTheme.typography.body1
        )
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailRowPreview() {
    DetailRow(
        title = "Weight",
        value = "80kg",
    )
}