package com.example.pokemontest.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemontest.domain.model.Type
import com.example.pokemontest.domain.model.TypeItem


@Composable
fun TypeRow(
    title: String,
    types:  List<Type>,
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
        Row() {
            types.map {
                Text(
                    text = it.type.name,
                    style = MaterialTheme.typography.body1,
                )
                Spacer(modifier = modifier.requiredSize(10.dp))
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TypeRowPreview() {
    TypeRow(
        title = "Weight",
        types = listOf(
            Type(
            type = TypeItem(
                name=""
            )
        )
        ),
    )
}