package com.kb.m1.intro

import java.io.FileReader
import java.io.IOException
import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {
    println("Hello, World")



}

/*
 ======== Behind the Scene ==========

 * Use fernflower to decomplie - https://github.com/fesh0r/fernflower

 * install java & run the jar
    $sudo apt install openjdk-11-jre-headless
    $java -jar sandbox/lib/fernflower.jar out/production/code-idioms_kotlin/com/kb/m1/intro/MainKt.class  sandbox/decompiled/

    krishnam@ubuntu:~/proj/github/code_idioms/code-idioms_kotlin$ java -cp out/production/code-idioms_kotlin/ com.kb.m1.intro.MainKt

    Exception in thread "main" java.lang.NoClassDefFoundError: kotlin/jvm/internal/Intrinsics
            at com.kb.m1.intro.MainKt.main(hello.kt)
    Caused by: java.lang.ClassNotFoundException: kotlin.jvm.internal.Intrinsics
            at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
            at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
            at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        ... 1 more

    Why: It is looking for Kotlin runtime (new name is kotlin stdlib jar ). Look decompiled dir for java source code of this class

    $java -cp "out/production/code-idioms_kotlin/:kotlin-java-runtime-lib/kotlin-stdlib.jar" com.kb.m1.intro.MainKt
    Hello, World

 ======= Common Mistakes======

 Main args - Array - not ArrayList

 */