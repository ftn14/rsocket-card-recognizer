package com.ftx.h1.inside.service

import java.awt.image.BufferedImage

interface RecognitionService {

    /**
     * Recognize stack size from image.
     */
    suspend fun recognizeChips(img: BufferedImage): String

    /**
     * Recognize card's rank and value from image.
     */
    suspend fun recognizeCard(cardImg: BufferedImage): String
}
