package com.ftx.h1.inside

import com.ftx.h1.inside.service.Tess4jRecognitionServiceImpl
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.test.context.ActiveProfiles

@Suppress("EXPERIMENTAL_API_USAGE")
@TestConfiguration
@ActiveProfiles("test")
@SpringBootTest
class Tess4jRecognitionServiceImplTest(@Autowired private val tess4jService: Tess4jRecognitionServiceImpl) {

    @SuppressWarnings
    @Test
    fun `recognize bet size 2,75`() {
        val img = TestUtils.getImgFromResource("/recognition/chips/bet_2_75.jpg")
        runBlockingTest {
            val result = tess4jService.recognizeChips(img)
            Assert.assertEquals("2.75", result)
        }
    }

    @Test
    fun `recognize 10 hearts`() {
        val img = TestUtils.getImgFromResource("/recognition/hand/card/10h.jpg")
        runBlockingTest {
            val result = tess4jService.recognizeCard(img)
            Assert.assertEquals("Th", result)
        }
    }

    @Test
    fun `recognize 4 diamonds`() {
        val img = TestUtils.getImgFromResource("/recognition/hand/card/4d.jpg")
        runBlockingTest {
            val result = tess4jService.recognizeCard(img)
            Assert.assertEquals("4d", result)
        }
    }

    // TODO:L another cards recognition
}
