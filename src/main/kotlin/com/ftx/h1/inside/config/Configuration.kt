package com.ftx.h1.inside.config

import net.sourceforge.tess4j.ITesseract
import net.sourceforge.tess4j.Tesseract1
import net.sourceforge.tess4j.util.LoadLibs
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {

    @Bean
    fun tesseractInstance(): ITesseract {
        val tesseractInstance = Tesseract1() // JNA Direct Mapping; for JNA Interface Mapping use: Tesseract()
        val tessDataFolder = LoadLibs.extractTessResources("tessdata")  // Maven build bundles English data
        tesseractInstance.setDatapath(tessDataFolder.path)
        return tesseractInstance
    }
}
