package org.example

import java.io.File

fun main() {
    d3p2()
}

fun d3p2() {
    val reader = File("C:\\Users\\ryan7\\OneDrive - Imperial College London\\Desktop\\LabWork\\AdventOfCode\\src\\main\\d3.txt").bufferedReader()
    val inputLines = reader.useLines { it.toList() }

    var count = 0
    var doBool = true
    for (line in inputLines) {
        var i = 0
        println(line)
        while (i < line.length) {
            while (i < line.length && line[i] != 'm' && line[i] != 'd') i++

            if (i + 2 <= line.length && line.substring(i, i+2) == "do") {
                if (i + 4 <= line.length && line.substring(i, i+4) == "do()") {
                    doBool = true
                    i += 4
                } else if (i + 7 <= line.length && line.substring(i, i+7) == "don't()") {
                    doBool = false
                    i += 7
                } else i++
            } else if (doBool && i + 4 <= line.length && line.substring(i, i+4) == "mul(") {
                i += 4
                val sb = StringBuilder()
                var validInside = true
                while (line[i] != ')') {
                    if (line[i].isDigit() || line[i] == ',') {
                        sb.append(line[i])
                        i++
                    } else {
                        validInside = false
                        i --
                        break
                    }
                }
                i ++

                if (validInside) {
                    val nums = sb.toString().split(",")
                    if (nums.size == 2) {
                        try {
                            val num1 = nums[0].toInt()
                            val num2 = nums[1].toInt()

                            count += num1 * num2
                        } catch(_: Exception) { }
                    }
                }
            } else i++
        }
    }

    println(count)
}

fun d3p1() {
    val reader = File("C:\\Users\\ryan7\\OneDrive - Imperial College London\\Desktop\\LabWork\\AdventOfCode\\src\\main\\d3.txt").bufferedReader()
    val inputLines = reader.useLines { it.toList() }

    var count = 0
    for (line in inputLines) {
        var i = 0
        println(line)
        while (i < line.length) {
            while (i < line.length && line[i] != 'm') i++

            if (i + 4 <= line.length && line.substring(i, i+4) == "mul(") {
                i += 4
                val sb = StringBuilder()
                var validInside = true
                while (line[i] != ')') {
                    if (line[i].isDigit() || line[i] == ',') {
                        sb.append(line[i])
                        i++
                    } else {
                        validInside = false
                        i --
                        break
                    }
                }
                i ++

                if (validInside) {
                    val nums = sb.toString().split(",")
                    if (nums.size == 2) {
                        try {
                            val num1 = nums[0].toInt()
                            val num2 = nums[1].toInt()

                            count += num1 * num2
                        } catch(_: Exception) { }
                    }
                }
            } else i++
        }
    }

    println(count)
}