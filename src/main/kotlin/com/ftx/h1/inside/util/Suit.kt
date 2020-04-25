package com.ftx.h1.inside.util

enum class Suit(val code: Char) {
    DIAMONDS('d'),
    SPADES('s'),
    CLUBS('c'),
    HEARTS('h');
    
    override fun toString() = "$code"
}
