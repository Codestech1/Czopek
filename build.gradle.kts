plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.github.codestech.czopek"
version = "1.0"

application {
    mainClass.set("com.github.codestech.czopek.Main")
}