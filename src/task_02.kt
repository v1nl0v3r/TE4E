fun main(args: Array<String>) {
    val testTable = tableGenerator(10,0,9)
    val numberTable: MutableList<Number> = testTable.map { it as Number } as MutableList<Number>
    println(numberTable)

// 1. Znajdź największy element w tablicy (cyfry 0-9)
    println(findMaxElementInTable(numberTable))

// 2. Znajdź najmniejszy element w tablicy (cyfry 0-9)
    println(findMinElementInTable(numberTable))

// 3. Znajdź drugi największy element (vice-max) w tablicy (cyfry 0-9)
    quickSort(numberTable, 0, numberTable.size - 1)
    println(numberTable[numberTable.size - 2])

// 4. Oblicz sumę wszystkich elementów tablicy (liczby 10-99)
    val ex4testTable = tableGenerator(10,10,99)
    val ex4numberTable = ex4testTable.map { it as Number } as MutableList<Number>
    println(tableSum(ex4numberTable))

// 5. Oblicz sumę elementów parzystych w tablicy (cyfry 0-9)
    println(sumEven(testTable))
// 6. Oblicz sumę elementów nieparzystych w tablicy (cyfry 0-9)
    println(sumOdd(testTable))
// 7. Sprawdź czy tablica jest lustrzana (palindrom) (cyfry 0-9)
    println(isPalindrome("Ala"))
// 8. Sprawdź czy suma elementów na parzystych indeksach równa się sumie na nieparzystych indeksach (cyfry 0-9)
    println(sumEven(testTable) == sumOdd(testTable))
// 9. Sprawdź czy tablica jest "skacząca" - elementy naprzemiennie mniejsze i większe (cyfry 0-9)
    println(isJumpableTable(mutableListOf<Double>(1.0, 3.0, 2.0, 5.0, 4.0)))
// 10. Policz ile jest liczb parzystych w tablicy (cyfry 0-9)
    println(howManyEvenInTable(testTable))
}

fun findMaxElementInTable(table: MutableList<Number>):Number{
    var max = 0.0;
    for(number in table){
        val temp = number.toDouble()
        if(temp > max){
            max = temp
        }
    }
    return max
}

fun findMinElementInTable(table: MutableList<Number>): Number{
    var min = table[0].toDouble();
    for(number in table){
        val temp = number.toDouble()
        if(temp < min){
            min = temp
        }
    }
    return min
}

fun tableSum(table: List<Number>):Number{
    var sum = 0.0

    for (number in table){
        sum += number.toDouble()
    }

    return sum
}

fun sumEven(table: List<Int>) = table.filter { it % 2 == 0 }.sum()

fun sumOdd(table: List<Int>) = table.filter { it % 2 != 0 }.sum()

fun isPalindrome(string: String): Boolean{
    val stringLength = string.length-1
    val stringLowercase = string.lowercase()

    stringLowercase.forEachIndexed { index, character ->   if (character != stringLowercase[stringLength-index]) return false}
    return true
}

fun isJumpableTable(table: MutableList<Double>): Boolean{
    var prevRising = table[1] > table[0]

    for (i in 2 until table.size) {
        val rising = table[i] > table[i-1]
        if(rising == prevRising) return false

        prevRising = rising
    }

    return true
}

fun howManyEvenInTable(table: MutableList<Int>): Int{
    var counterOfEven = 0
    table.forEach { if(it%2 == 0) counterOfEven++ }
    return counterOfEven
}

fun rangeIdentifier(min: Number, max: Number, numberToCheck: Number): Boolean {
    return numberToCheck.toDouble() in  min.toDouble() .. max.toDouble()
}

fun tableGenerator(length:Int, min: Int, max: Int): MutableList<Int>{
    val result = mutableListOf<Int>()
    for(i in 0 until length){
        result.add((min..max).random())
    }
    return result
}

fun quickSort(array: MutableList<Number>, start:Int, end:Int){
    if(start < end){
        val pivotIndex = partition(array, start, end)
        quickSort(array, start, pivotIndex - 1)
        quickSort(array, pivotIndex + 1, end)
    }
}

fun partition(array: MutableList<Number>, start:Int, end:Int):Int{
    var i = start - 1
    var j = start
    val pivot = array[end].toDouble()


    while(j < end){
        if (array[j].toDouble() < pivot){
            i++
            array[i] = array[j].also {array[j] = array[i]}
        }
        j++
    }
    i++
    array[i] = array[end].also {array[end] = array[i]}

    return i
}