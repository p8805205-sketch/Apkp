package com.sumberilmu.app.data

internal fun <T> Iterable<T>.shuffled(random: java.util.Random): List<T> =
    toMutableList().also { java.util.Collections.shuffle(it, random) }
