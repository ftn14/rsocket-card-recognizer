package com.ftx.h1.inside.util

enum class CardRank(val code: Char) {
    ACE('A'),
    KIND('K'),
    QUEEN('Q'),
    JACK('J'),
    TEN('T'),
    NINE('9'),
    EIGHT('8'),
    SEVEN('7'),
    SIX('6'),
    FIVE('5'),
    FOUR('4'),
    THREE('3'),
    TWO('2');

    companion object {
        fun byChar(char: Char): CardRank? = values().firstOrNull { it.code == char }
    }

    override fun toString(): String = "$code"
}
