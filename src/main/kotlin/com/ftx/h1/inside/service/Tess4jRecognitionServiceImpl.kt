package com.ftx.h1.inside.service

import com.ftx.h1.inside.util.CardRank
import com.ftx.h1.inside.util.getCardColor
import com.ftx.h1.inside.util.toSuit
import mu.KotlinLogging
import net.sourceforge.tess4j.ITesseract
import org.springframework.stereotype.Service
import java.awt.image.BufferedImage

private val logger = KotlinLogging.logger {}

@Service
class Tess4jRecognitionServiceImpl(private val tesseractInstance: ITesseract) : RecognitionService {

    private final val CHIPS_REGEX: Regex = """\d+\.\d+""".toRegex()

    override suspend fun recognizeChips(img: BufferedImage): String {
        val chips = tesseractInstance.doOCR(img).split(" ")[0]
        return when (CHIPS_REGEX.containsMatchIn(chips)) {
            true -> chips
            else -> throw IllegalStateException("incorrect result of sizing recognition: $chips")
        }
    }

    override suspend fun recognizeCard(cardImg: BufferedImage): String {
        val cardRankAfterOcr: String = tesseractInstance.doOCR(cardImg)
            .apply { logger.debug { "Recognized card value = $this (${this.length} chars)" } }
        val cardRankCharacter = cardRankAfterOcr
            .trim()
            .replace("""[1]?0""".toRegex(), "T")[0]
        val rank = CardRank.byChar(cardRankCharacter) ?: throw IllegalStateException("Unable to recognize card value")
        val suit = cardImg
            .getCardColor().apply { logger.debug { "Suit color: $this" } }
            .toSuit()
        return "$rank$suit"
    }

}