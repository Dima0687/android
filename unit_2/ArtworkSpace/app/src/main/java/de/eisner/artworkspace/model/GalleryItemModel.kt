package de.eisner.artworkspace.model

import androidx.annotation.ArrayRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class GalleryItemModel(
    val categoryIndex: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val contentDescriptionRes: Int,
    @ArrayRes val strengthsRes: Int,
    @ArrayRes val shadowsRes: Int,
    @StringRes val analysis: Int,
)
