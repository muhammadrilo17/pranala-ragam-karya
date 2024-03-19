package com.rilodev.pranala.utils

object Utils {
    fun getPrimaNumber(n: Int): String {
        var i = 2
        var result = ""
        while (i <= n) {
            if(i == 2 || i == 3 || i == 5 || i == 7) {
                if(result != "") result += ", "
                result += i.toString()
            } else {
                if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                    if(result != "") result += ", "
                    result += i.toString()
                }
            }
            ++i
        }

        return result
    }
}