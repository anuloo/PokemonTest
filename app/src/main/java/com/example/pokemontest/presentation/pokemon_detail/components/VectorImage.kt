package com.example.pokemontest.presentation.pokemon_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.pokemontest.R

@Composable
fun VectorImage(
    modifier: Modifier,
    url: String,
) {
    val context = LocalContext.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(url)
            .placeholder(R.drawable.ic_baseline_image_search_24)
            .decoderFactory(SvgDecoder.Factory())
            .build()
    )

    Image(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .aspectRatio(1f),
        painter = painter,
        contentDescription = null
    )

}