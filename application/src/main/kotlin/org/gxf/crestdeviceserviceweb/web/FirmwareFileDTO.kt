// SPDX-FileCopyrightText: Contributors to the GXF project
//
// SPDX-License-Identifier: Apache-2.0
package org.gxf.crestdeviceserviceweb.web

data class FirmwareFileDTO(val packets: List<FirmwarePacket>) {
    data class FirmwarePacket(val packetNumber: Int, val packet: String)
}
