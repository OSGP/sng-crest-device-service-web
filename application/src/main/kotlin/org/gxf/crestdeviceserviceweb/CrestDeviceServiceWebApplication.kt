// SPDX-FileCopyrightText: Contributors to the GXF project
//
// SPDX-License-Identifier: Apache-2.0
package org.gxf.crestdeviceserviceweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling @SpringBootApplication class CrestDeviceServiceWebApplication

fun main(args: Array<String>) {
    runApplication<CrestDeviceServiceWebApplication>(*args)
}
