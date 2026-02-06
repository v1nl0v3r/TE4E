import kotlin.math.pow

fun main(){
    println(isArmstrongNumber(153))
    println(sumOfProperDivisors(12))
    println(isTriangularNumber(276))
    println(maxNumberDigit(29467))
}
fun digitsList(number:Int): List<Int>{
    var temp = number
    val result = mutableListOf<Int>()
    while(temp != 0){
        result.add(temp % 10)
        temp /= 10
    }

    return result
}

fun isArmstrongNumber(number: Int): Boolean{
    val numberDigits = digitsList(number)
    val power = numberDigits.size
    var sum = 0
    numberDigits.forEach { sum += (it.toDouble().pow(power.toDouble())).toInt() }

    return sum == number
}

fun sumOfProperDivisors(number:Int):Int{
    val divisors = divisorsFromGivenRange(number,1 until number)
    return divisors.sum()
}

fun isTriangularNumber(number:Int): Boolean{
    var sum = 0
    var index = 1

    while (sum != number){
        sum += index
        index++
        if (sum > number) return false
    }
    return true
}

fun maxNumberDigit(number: Int) = digitsList(number).max()