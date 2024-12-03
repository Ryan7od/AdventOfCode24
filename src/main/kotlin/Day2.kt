package org.example

import java.io.File
import kotlin.math.abs

fun main() {
    d2p2()
}

fun d2p2() {
    val reader = File("C:\\Users\\ryan7\\OneDrive - Imperial College London\\Desktop\\LabWork\\AdventOfCode\\src\\main\\d2.txt").bufferedReader()
    val inputLines = reader.useLines { it.toList() }

    var count = 0
    for (line in inputLines) {
        val report = line.split(" ").map { it.toInt() }

        if (evaluate(report.toMutableList())) {
            count++
        } else {
            var success = 0
            for (i in 0..<(report.size)) {
                val reportCut = report.toMutableList()
                reportCut.removeAt(i)
                println(reportCut)
                if (evaluate(reportCut)) {
                    success = 1
                    break
                }
            }
            count += success
        }
    }

    println(count)
}

fun evaluate(report: MutableList<Int>): Boolean {
    if (report.size <= 1) return true

    val direction = report[0] <= report[1]

    for (i in 0..<(report.size - 1)) {
        val diff = abs(report[i] - report[i + 1])
        if (diff < 1 || diff > 3) {
            return false
        }

        if (direction) {
            if (report[i + 1] < report[i]) {
                return false
            }
        } else {
            if (report[i + 1] > report[i]) {
                return false
            }
        }
    }

    return true
}

fun d2p1() {
    val reader = File("C:\\Users\\ryan7\\OneDrive - Imperial College London\\Desktop\\LabWork\\AdventOfCode\\src\\main\\d2.txt").bufferedReader()
    val inputLines = reader.useLines { it.toList() }

    var count = 0
    for (line in inputLines) {
        val report = line.split(" ").map { it.toInt() }

        if (report.size <= 1) {
            count++
            continue
        }

        val direction = if (report[0] > report[1]) false else true

        for (i in 0..<(report.size - 1)) {
            val diff = abs(report[i] - report[i + 1])
            if (diff < 1 || diff > 3) {
                count--
                break
            }

            if (direction) {
                if (report[i + 1] < report[i]) {
                    count--
                    break
                }
            } else {
                if (report[i + 1] > report[i]) {
                    count--
                    break
                }
            }
        }
        count++
    }

    println(count)
}