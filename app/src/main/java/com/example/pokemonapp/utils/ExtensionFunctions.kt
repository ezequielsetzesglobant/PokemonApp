package com.example.pokemonapp.utils

import com.example.pokemonapp.R

fun String.getImageId() = when (this) {
    Types.COLORLESS -> R.drawable.colorless
    Types.DARKNESS -> R.drawable.darkness
    Types.DRAGON -> R.drawable.dragon
    Types.FAIRY -> R.drawable.fairy
    Types.FIGHTING -> R.drawable.fighting
    Types.FIRE -> R.drawable.fire
    Types.GRASS -> R.drawable.grass
    Types.LIGHTNING -> R.drawable.lightning
    Types.METAL -> R.drawable.metal
    Types.PSYCHIC -> R.drawable.psychic
    Types.WATER -> R.drawable.water
    else -> R.drawable.default_pokeball
}

private object Types {
    const val COLORLESS = "Colorless"
    const val DARKNESS = "Darkness"
    const val DRAGON = "Dragon"
    const val FAIRY = "Fairy"
    const val FIGHTING = "Fighting"
    const val FIRE = "Fire"
    const val GRASS = "Grass"
    const val LIGHTNING = "Lightning"
    const val METAL = "Metal"
    const val PSYCHIC = "Psychic"
    const val WATER = "Water"
}
