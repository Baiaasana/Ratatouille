package com.example.designsystem.components.footer

import com.example.ratatouille.R
import com.example.ratatouille.navigation.NavTarget

@kotlinx.serialization.Serializable
sealed class BottomScreens<T>(val name: Int, val icon: Int, val route: T) {
    @kotlinx.serialization.Serializable
    data object Home : BottomScreens<NavTarget.Home>(
        name = R.string.home_name,
        icon = R.drawable.ic_home,
        route = NavTarget.Home
    )

    @kotlinx.serialization.Serializable
    data object Search : BottomScreens<NavTarget.Search>(
        name = R.string.search,
        icon = R.drawable.ic_search,
        route = NavTarget.Search
    )

    @kotlinx.serialization.Serializable
    data object Randomizer : BottomScreens<NavTarget.Randomizer>(
        name = R.string.randomizer,
        icon = R.drawable.ic_transactions,
        route = NavTarget.Randomizer
    )


}