// SPDX-FileCopyrightText: Contributors to the GXF project
//
// SPDX-License-Identifier: Apache-2.0

rootProject.name = "sng-crest-device-service-web"

include("application")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlinLogging", "7.0.0")
            version("mockitoKotlin", "5.4.0")

            library("logging", "io.github.oshai", "kotlin-logging-jvm").versionRef("kotlinLogging")
            library("mockitoKotlin", "org.mockito.kotlin", "mockito-kotlin").versionRef("mockitoKotlin")
        }
    }
}
