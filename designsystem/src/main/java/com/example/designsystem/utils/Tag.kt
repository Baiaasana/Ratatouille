package com.example.designsystem.utils

import android.content.Context
import com.example.designsystem.R

enum class Tag(val value: Int, val toServer: String) {
    LUXURY(value = R.string.luxury, toServer = "Luxury"),
    VINTAGE(value = R.string.vintage, toServer = "Vintage"),
    DURABLE(value = R.string.durable, toServer = "Durable"),
    COMPACT(value = R.string.compact, toServer = "Compact"),
    PORTABLE(value = R.string.portable, toServer = "Portable"),
    INNOVATIVE(value = R.string.innovative, toServer = "Innovative"),
    STYLISH(value = R.string.stylish, toServer = "Stylish"),
    MODERN(value = R.string.modern, toServer = "Modern"),
    UNIQUE(value = R.string.unique, toServer = "Unique"),
    HANDMADE(value = R.string.handmade, toServer = "Handmade"),
    ECO_FRIENDLY(value = R.string.eco_friendly, toServer = "Eco-friendly"),
    LIMITED(value = R.string.limited, toServer = "Limited"),
    RARE(value = R.string.rare, toServer = "Rare"),
    FUNCTIONAL(value = R.string.functional, toServer = "Functional"),
    VERSATILE(value = R.string.versatile, toServer = "Versatile"),
    CHIC(value = R.string.chic, toServer = "Chic"),
    TRENDY(value = R.string.trendy, toServer = "Trendy"),
    CUSTOM(value = R.string.custom, toServer = "Custom"),
    SLEEK(value = R.string.sleek, toServer = "Sleek"),
    LIGHTWEIGHT(value = R.string.lightweight, toServer = "Lightweight"),
    SMART(value = R.string.smart, toServer = "Smart"),
    ROBUST(value = R.string.robust, toServer = "Robust"),
    EFFICIENT(value = R.string.efficient, toServer = "Efficient"),
    INTERACTIVE(value = R.string.interactive, toServer = "Interactive"),
    COLORFUL(value = R.string.colorful, toServer = "Colorful"),
    ELEGANT(value = R.string.elegant, toServer = "Elegant"),
    BOLD(value = R.string.bold, toServer = "Bold"),
    SOFT(value = R.string.soft, toServer = "Soft"),
    COMFORTABLE(value = R.string.comfortable, toServer = "Comfortable"),
    BREATHABLE(value = R.string.breathable, toServer = "Breathable"),
    ADJUSTABLE(value = R.string.adjustable, toServer = "Adjustable"),
    MULTI_PURPOSE(value = R.string.multi_purpose, toServer = "Multi-purpose"),
    QUICK(value = R.string.quick, toServer = "Quick"),
    RELIABLE(value = R.string.reliable, toServer = "Reliable"),
    PREMIUM(value = R.string.premium, toServer = "Premium"),
    ORIGINAL(value = R.string.original, toServer = "Original"),
    INTUITIVE(value = R.string.intuitive, toServer = "Intuitive"),
    LUXURIOUS(value = R.string.luxurious, toServer = "Luxurious"),
    WATERPROOF(value = R.string.waterproof, toServer = "Waterproof"),
    WIRELESS(value = R.string.wireless, toServer = "Wireless"),
    HIGH_TECH(value = R.string.high_tech, toServer = "High-tech"),
    ENERGY(value = R.string.energy, toServer = "Energy"),
    REFRESHING(value = R.string.refreshing, toServer = "Refreshing"),
    CUSTOMIZABLE(value = R.string.customizable, toServer = "Customizable"),
    SAFE(value = R.string.safe, toServer = "Safe"),
    AFFORDABLE(value = R.string.affordable, toServer = "Affordable"),
    ARTISTIC(value = R.string.artistic, toServer = "Artistic"),
    TRENDSETTING(value = R.string.trendsetting, toServer = "Trendsetting"),
    CLASSIC_TAG(value = R.string.classic_tag, toServer = "Classic"),
    EFFORTLESS(value = R.string.effortless, toServer = "Effortless"),
    SOPHISTICATED(value = R.string.sophisticated, toServer = "Sophisticated"),
    WARM(value = R.string.warm, toServer = "Warm"),
    VIBRANT(value = R.string.vibrant, toServer = "Vibrant"),
    REUSABLE(value = R.string.reusable, toServer = "Reusable"),
    ACCESSIBLE(value = R.string.accessible, toServer = "Accessible"),
    ATTRACTIVE(value = R.string.attractive, toServer = "Attractive"),
    ARTISAN(value = R.string.artisan, toServer = "Artisan"),
    REFINED(value = R.string.refined, toServer = "Refined"),
    GRACEFUL(value = R.string.graceful, toServer = "Graceful"),
    CONTEMPORARY(value = R.string.contemporary, toServer = "Contemporary"),
    NATURAL(value = R.string.natural, toServer = "Natural"),
    STURDY(value = R.string.sturdy, toServer = "Sturdy"),
    PLEASURABLE(value = R.string.pleasurable, toServer = "Pleasurable"),
    IMPRESSIVE(value = R.string.impressive, toServer = "Impressive"),
    GENEROUS(value = R.string.generous, toServer = "Generous"),
    INSPIRING(value = R.string.inspiring, toServer = "Inspiring"),
    WHIMSICAL(value = R.string.whimsical, toServer = "Whimsical"),
    TRUSTWORTHY(value = R.string.trustworthy, toServer = "Trustworthy"),
    SERENE(value = R.string.serene, toServer = "Serene"),
    CAPTIVATING(value = R.string.captivating, toServer = "Captivating"),
    CHARMING(value = R.string.charming, toServer = "Charming"),
    NOURISHING(value = R.string.nourishing, toServer = "Nourishing"),
    PASSIONATE(value = R.string.passionate, toServer = "Passionate"),
    AFFECTIONATE(value = R.string.affectionate, toServer = "Affectionate"),
    REWARDING(value = R.string.rewarding, toServer = "Rewarding"),
    IMPACTFUL(value = R.string.impactful, toServer = "Impactful"),
    RESILIENT(value = R.string.resilient, toServer = "Resilient"),
    GROUNDBREAKING(value = R.string.groundbreaking, toServer = "Groundbreaking"),
    OPTIMISTIC(value = R.string.optimistic, toServer = "Optimistic"),
    THOUGHTFUL(value = R.string.thoughtful, toServer = "Thoughtful"),
    AMBITIOUS(value = R.string.ambitious, toServer = "Ambitious"),
    DYNAMIC(value = R.string.dynamic, toServer = "Dynamic"),
    FEARLESS(value = R.string.fearless, toServer = "Fearless"),
    SAVVY(value = R.string.savvy, toServer = "Savvy"),
    TRANSFORMATIVE(value = R.string.transformative, toServer = "Transformative")
}

fun getToServerFromResourceTag(context: Context, resourceString: String): String {
    val matchingEnum = Tag.values().find { context.getString(it.value) == resourceString }
    return matchingEnum?.toServer.toString()
}

fun getValueFromToServerTag(toServer: String): Int? {
    val matchingEnum = Tag.values().find { it.toServer == toServer }
    return matchingEnum?.value
}
