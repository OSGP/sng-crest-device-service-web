// SPDX-FileCopyrightText: Copyright Contributors to the GXF project
//
// SPDX-License-Identifier: Apache-2.0
package org.gxf.crestdeviceserviceweb.http

import io.github.oshai.kotlinlogging.KotlinLogging
import org.gxf.crestdeviceserviceweb.web.FirmwareDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestClient
import org.springframework.web.client.toEntity

@Component
class HttpClient(private val webClient: RestClient) {
    companion object {
        const val MESSAGE_PATH = "/firmware"
    }

    private val logger = KotlinLogging.logger {}

    @Throws(HttpClientErrorException::class, HttpServerErrorException::class)
    fun postFirmware(firmware: FirmwareDTO): ResponseEntity<String> {
        logger.debug {
            "Posting firmware with name ${firmware.name} and ${firmware.packets.size} packets"
        }

        try {
            val response = executeRequest(firmware)
            logger.debug {
                "Posted message with name ${firmware.name}, resulting response: $response"
            }
            return response
        } catch (e: Exception) {
            logger.warn { "Error received while posting message with id ${firmware.name}" }
            throw e
        }
    }

    @Throws(HttpClientErrorException::class, HttpServerErrorException::class)
    private fun executeRequest(firmware: FirmwareDTO): ResponseEntity<String> =
        webClient
            .post()
            .uri("$MESSAGE_PATH/${firmware.name}")
            .body(firmware)
            .retrieve()
            .toEntity<String>()
}
