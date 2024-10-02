// SPDX-FileCopyrightText: Contributors to the GXF project
//
// SPDX-License-Identifier: Apache-2.0
package org.gxf.crestdeviceserviceweb.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class FirmwareService {
    private val logger = KotlinLogging.logger {}
    private val mapper = jacksonObjectMapper()

    fun processFirmwareFile(file: MultipartFile): Int {
        logger.info { "Processing file: ${file.originalFilename}" }
        val firmwareFileDTO = mapFirmwareFileToDTO(file)
        logger.info { "Processing ${firmwareFileDTO.packets.size} packets from firmware file" }

        return firmwareFileDTO.packets.size
    }

    fun mapFirmwareFileToDTO(file: MultipartFile): FirmwareFileDTO {
        val fileContent = String(file.inputStream.readBytes())

        logger.debug { "Contents of firmware file:\n${fileContent}" }

        return mapper.readValue<FirmwareFileDTO>(fileContent)
    }
}
