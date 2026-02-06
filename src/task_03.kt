import kotlin.math.pow

fun main(){
 println(isArmstrongNumber(153))
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

