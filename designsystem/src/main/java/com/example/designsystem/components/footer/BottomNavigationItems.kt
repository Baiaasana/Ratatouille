package com.example.designsystem.components.footer

import com.example.navigation.NavTarget
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
sealed class BottomScreens<T>(val name: Int, val icon: Int, val route: T) {
    @kotlinx.serialization.Serializable
    data object Home : BottomScreens<NavTarget.Home>(
        name = com.example.designsystem.R.string.home_name,
        icon = com.example.designsystem.R.drawable.ic_home,
        route = NavTarget.Home
    )

    @kotlinx.serialization.Serializable
    data object Profile : BottomScreens<NavTarget.Profile>(
        name = com.example.designsystem.R.string.profile,
        icon = com.example.designsystem.R.drawable.ic_profile,
        route = NavTarget.Profile
    )

    @kotlinx.serialization.Serializable
    data object BidHistory : BottomScreens<NavTarget.BidHistory>(
        name = com.example.designsystem.R.string.bid_history,
        icon = com.example.designsystem.R.drawable.ic_bids,
        route = NavTarget.BidHistory
    )

    @Serializable
    data object LiveAuction : BottomScreens<NavTarget.LiveAuctions>(
        name =  com.example.designsystem.R.string.auctions,
        icon = com.example.designsystem.R.drawable.ic_live_auctions,
        route = NavTarget.LiveAuctions
    )
}