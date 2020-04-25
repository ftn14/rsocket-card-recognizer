package com.ftx.h1.inside.util

import java.awt.Color
import java.awt.image.BufferedImage

fun BufferedImage.getCardColor(): Color {
    val centerX = width / 2
    val centerY = height / 2
    val centerColor = getRGB(centerX, centerY).toColor()
    return if (centerColor.isWhite()) {
        searchNonWhiteColorHorizontally(step = 1, img = this, startPoint = Pair(centerX, centerY))
    } else centerColor
}

fun Color.isWhite(): Boolean = when {
    red > 200 && green > 200 && blue > 200 -> true
    else -> false
}

private fun searchNonWhiteColorHorizontally(step: Int, img: BufferedImage, startPoint: Pair<Int, Int>): Color {
    val colorLeft = img.getRGB(startPoint.first, startPoint.second - step).toColor()
    return when {
        colorLeft.isWhite() -> {
            val colorRight = img.getRGB(startPoint.first, startPoint.second + step).toColor()
            when {
                colorRight.isWhite() ->
                    if (step < img.width / 2) searchNonWhiteColorHorizontally(step = step + 1, img = img, startPoint = startPoint)
                    else throw IllegalStateException("Only white pixels were found!")
                else -> colorRight
            }
        }
        else -> colorLeft
    }
}

fun Int.toColor(): Color {
    val red   = (this and 0x00ff0000) shr 16
    val green = (this and 0x0000ff00) shr 8
    val blue  =  this and  0x000000ff
    return Color(red, green, blue)
}

fun Color.toSuit(): Suit = when {
    red > 100 -> Suit.HEARTS
    green > 100 -> Suit.CLUBS
    blue > 100 -> Suit.DIAMONDS
    else -> Suit.SPADES
}