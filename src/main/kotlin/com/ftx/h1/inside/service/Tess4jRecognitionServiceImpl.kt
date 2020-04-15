package com.ftx.h1.inside.service

import mu.KotlinLogging
import net.sourceforge.tess4j.ITesseract
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage

@Service
class Tess4jRecognitionServiceImpl(private val tesseractInstance: ITesseract) : RecognitionService {

    private val logger = KotlinLogging.logger {}

    private final val CHIPS_REGEX: Regex = """\d+\.\d+""".toRegex()

    override suspend fun recognizeChips(img: BufferedImage): String {
        val result = tesseractInstance.doOCR(img).split(" ")[0]
        return when (CHIPS_REGEX.containsMatchIn(result)) {
            true -> result
            else -> throw IllegalStateException("incorrect result of sizing recognition: $result")
        }
    }

    override suspend fun recognizeHand() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}