package com.ftx.h1.inside.service

import java.awt.image.BufferedImage

interface RecognitionService {

    suspend fun recognizeChips(img: BufferedImage): String

    suspend fun recognizeCard(cardImg: BufferedImage): String
}
