package de.eisner.thirtydaysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @DrawableRes val imageId: Int,
    @StringRes val imageDescription: Int? = null,
    @StringRes val textId: Int,
    @StringRes val dayResId: Int,
)
