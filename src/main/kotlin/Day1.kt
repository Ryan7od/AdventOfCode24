package org.example

import java.io.File
import kotlin.math.abs

fun main() {
}

fun d1p2() {
    val reader = File("C:\\Users\\ryan7\\OneDrive - Imperial College London\\Desktop\\LabWork\\AdventOfCode\\src\\main\\d1.txt").bufferedReader()
    val inputLines = reader.useLines { lines ->
        lines.toList()
    }
    val list1: MutableList<Int> = mutableListOf()
    val list2: MutableList<Int> = mutableListOf()
    inputLines.forEach {
        val split = it.split("   ").map { s -> s.toInt() }
        list1.add(split[0])
        list2.add(split[1])
    }

    var count = 0
    for (i in list1) {
        count += i * list2.count { it == i }
    }

    println(count)
}

fun d1p1() {
    val reader = File("C:\\Users\\ryan7\\OneDrive - Imperial College London\\Desktop\\LabWork\\AdventOfCode\\src\\main\\d1.txt").bufferedReader()
    val inputLines = reader.useLines { lines ->
        lines.toList()
    }
    val list1: MutableList<Int> = mutableListOf()
    val list2: MutableList<Int> = mutableListOf()
    inputLines.forEach {
        val split = it.split("   ").map { s -> s.toInt() }
        list1.add(split[0])
        list2.add(split[1])
    }

    list1.sort()
    list2.sort()

    var count = 0
    for (i in list1.indices) {
        count += abs(list1[i] - list2[i])
    }

    println(count)
}
