import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
fun properties(key: String) = project.findProperty(key).toString()
plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
    // Gradle IntelliJ Plugin
//    id("org.jetbrains.intellij") version "1.10.0"
    id("org.jetbrains.intellij") version "1.11.0"
    // Gradle Changelog Plugin
    id("org.jetbrains.changelog") version "2.0.0"
    // Gradle Qodana Plugin
    id("org.jetbrains.qodana") version "0.1.13"
    // Gradle Kover Plugin
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
}

group = properties("pluginGroup")
version = properties("pluginVersion")

repositories {
    mavenCentral()
}

kotlin {
//    jvmToolchain(11)
    jvmToolchain(17)
}

intellij {
    pluginName.set(properties("pluginName"))
    version.set(properties("platformVersion"))
    type.set(properties("platformType"))

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins.set(properties("platformPlugins").split(',').map(String::trim).filter(String::isNotEmpty))
}

changelog {
    groups.set(emptyList())
    repositoryUrl.set(properties("pluginRepositoryUrl"))
}

qodana {
    cachePath.set(file(".qodana").canonicalPath)
    reportPath.set(file("build/reports/inspections").canonicalPath)
    saveReport.set(true)
    showReport.set(System.getenv("QODANA_SHOW_REPORT")?.toBoolean() ?: false)
}

// Configure Gradle Kover Plugin - read more: https://github.com/Kotlin/kotlinx-kover#configuration
kover.xmlReport {
    onCheck.set(true)
}


val myPluginVerison ="0.0.1"
tasks {
    wrapper {
        gradleVersion = properties("gradleVersion")
    }

    patchPluginXml {
//        version.set(properties("pluginVersion"))
        version.set(myPluginVerison)
        sinceBuild.set(properties("pluginSinceBuild"))
        untilBuild.set(properties("pluginUntilBuild"))

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription.set(
            file("README.md").readText().lines().run {
                val start = "<!-- Plugin description -->"
                val end = "<!-- Plugin description end -->"

                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end))
            }.joinToString("\n").let { markdownToHTML(it) }
        )

        // Get the latest available change notes from the changelog file

//        changeNotes.set(provider {
//            changelog.run {
//                getOrNull(properties("pluginVersion")) ?: getLatest()
//            }.toHTML()
//        })

//        changeNotes.set(provider {
//            with(changelog) {
//                renderItem(
//                    getOrNull(properties("pluginVersion")) ?: getLatest(),
//                    Changelog.OutputType.HTML,
//                )
//            }
//        })
    }
    runIdeForUiTests {
        systemProperty("robot-server.port", "8082")
        systemProperty("ide.mac.message.dialogs.as.sheets", "false")
        systemProperty("jb.privacy.policy.text", "<!--999.999-->")
        systemProperty("jb.consents.confirmation.enabled", "false")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token.set(System.getenv("PUBLISH_TOKEN"))
        channels.set(listOf(properties("pluginVersion").split('-').getOrElse(1) { "default" }.split('.').first()))
    }
}

changelog {
    version.set(properties("pluginVersion"))
//    version.set(myPluginVerison)
    path.set(file("CHANGELOG.md").canonicalPath)
    header.set(provider { "[${version.get()}] - ${org.jetbrains.changelog.date()}" })
    headerParserRegex.set("""(\d+\.\d+)""".toRegex())
    introduction.set(
        """
        My awesome project that provides a lot of useful features, like:

        - Feature 1
        - Feature 2
        - and Feature 3
        """.trimIndent()
    )
    itemPrefix.set("-")
    keepUnreleasedSection.set(true)
    unreleasedTerm.set("[Unreleased]")
    groups.set(listOf("Added", "Changed", "Deprecated", "Removed", "Fixed", "Security"))
    lineSeparator.set("\n")
    combinePreReleases.set(true)
}

dependencies {
    compileOnly(files("lib/wizard-template.jar"))
}
