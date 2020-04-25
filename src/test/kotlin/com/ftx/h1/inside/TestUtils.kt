package com.ftx.h1.inside

import java.awt.image.BufferedImage
import java.net.URL
import javax.imageio.ImageIO

object TestUtils {
    fun getResource(path: String): URL = this.javaClass.getResource(path)

    fun getImgFromResource(path: String): BufferedImage = ImageIO.read(getResource(path))
}