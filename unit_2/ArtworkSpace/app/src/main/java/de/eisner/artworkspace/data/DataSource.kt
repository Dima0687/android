package de.eisner.artworkspace.data

import de.eisner.artworkspace.R
import de.eisner.artworkspace.model.GalleryItemModel

object DataSource {

    /**
    * Categories    | Index
    *
    * ` Abstract =        0`
    *
    * ` Architecture =    1`
    *
    * ` Space =           2`
    *
    * ` Classic =         3`
    *
    * ` Fantasy =         4`
    *
    * ` Flower =          5`
    *
    * ` Love =            6`
    *
    * ` Nature =          7`
    *
    * ` Low-Poly =        8`
    *
    * ` Symbolic =        9`
    *
    * ` Animal =         10`
    *
    */
    fun loadGallery() = listOf(
        GalleryItemModel(
            categoryIndex = 0,
            imageRes = R.drawable.abstract_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.abstract_001_content_description,
            strengthsRes = R.array.abstract_strengths,
            shadowsRes = R.array.abstract_shadows,
            analysis = R.string.abstract_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 0,
            imageRes = R.drawable.abstract_002,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.abstract_002_content_description,
            strengthsRes = R.array.abstract_strengths,
            shadowsRes = R.array.abstract_shadows,
            analysis = R.string.abstract_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 1,
            imageRes = R.drawable.architecture_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.architecture_001_content_description,
            strengthsRes = R.array.architecture_strengths,
            shadowsRes = R.array.architecture_shadows,
            analysis = R.string.architecture_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 2,
            imageRes = R.drawable.astro_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.astro_001_content_description,
            strengthsRes = R.array.astronaut_strengths,
            shadowsRes = R.array.astronaut_shadows,
            analysis = R.string.astronaut_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 3,
            imageRes = R.drawable.classic_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.classic_001_content_description,
            strengthsRes = R.array.classic_strengths,
            shadowsRes = R.array.classic_shadows,
            analysis = R.string.classic_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 4,
            imageRes = R.drawable.fantasy_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.fantasy_001_content_description,
            strengthsRes = R.array.fantasy_strengths,
            shadowsRes = R.array.fantasy_shadows,
            analysis = R.string.fantasy_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 4,
            imageRes = R.drawable.fantasy_002,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.fantasy_002_content_description,
            strengthsRes = R.array.fantasy_strengths,
            shadowsRes = R.array.fantasy_shadows,
            analysis = R.string.fantasy_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 5,
            imageRes = R.drawable.flower_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.flower_001_content_description,
            strengthsRes = R.array.flower_strengths,
            shadowsRes = R.array.flower_shadows,
            analysis = R.string.flower_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 6,
            imageRes = R.drawable.heart_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.heart_001_content_description,
            strengthsRes = R.array.heart_strengths,
            shadowsRes = R.array.heart_shadows,
            analysis = R.string.heart_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 7,
            imageRes = R.drawable.nature_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.nature_001_content_description,
            strengthsRes = R.array.nature_strengths,
            shadowsRes = R.array.nature_shadows,
            analysis = R.string.nature_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 7,
            imageRes = R.drawable.nature_002,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.nature_002_content_description,
            strengthsRes = R.array.nature_strengths,
            shadowsRes = R.array.nature_shadows,
            analysis = R.string.nature_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 7,
            imageRes = R.drawable.nature_003,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.nature_003_content_description,
            strengthsRes = R.array.nature_strengths,
            shadowsRes = R.array.nature_shadows,
            analysis = R.string.nature_analysis,
        ),
        GalleryItemModel(
            categoryIndex = 8,
            imageRes = R.drawable.poly_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.poly_001_content_description,
            strengthsRes = R.array.poly_strengths,
            shadowsRes = R.array.poly_shadows,
            analysis = R.string.poly_analysis
        ),
        GalleryItemModel(
            categoryIndex = 9,
            imageRes = R.drawable.symbolic_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.symbolic_001_content_description,
            strengthsRes = R.array.symbolic_strengths,
            shadowsRes = R.array.symbolic_shadows,
            analysis = R.string.symbolic_analysis
        ),
        GalleryItemModel(
            categoryIndex = 10,
            imageRes = R.drawable.wolf_001,
            titleRes = R.string.title,
            contentDescriptionRes = R.string.wolf_001_content_description,
            strengthsRes = R.array.wolf_strengths,
            shadowsRes = R.array.wolf_shadows,
            analysis = R.string.wolf_analysis
        ),
    )
}