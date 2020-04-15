package com.ftx.h1.inside

import com.ftx.h1.inside.service.Tess4jRecognitionServiceImpl
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration

@TestConfiguration
@SpringBootTest
class Tess4jServiceImplTest(@Autowired private val tess4jService: Tess4jRecognitionServiceImpl) {

    @Test
    fun `recognize bet size 2,75`() {
        val img = TestUtils.getImgFromResource("/recognition/chips/bet_2_75.jpg")
        val result = runBlockingTest { tess4jService.recognizeChips(img) }
        Assert.assertEquals("2.75", result)
    }



}
