package com.ftx.h1.inside

import org.springframework.util.ResourceUtils
import java.net.URL
import javax.imageio.ImageIO

object TestUtils {
    fun getResource(path: String): URL = this.javaClass.getResource(path)

    fun getFileFromResource(path: String) = ResourceUtils.getFile(this.javaClass.getResource(path))

    fun getImgFromResource(path: String) = ImageIO.read(getResource(path))
}