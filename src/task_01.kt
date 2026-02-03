//1. Algorytm Euklidesa odejmowanie
//2. Algorytm Euklidesa modulo
//3. Fibonacci n-ty wyraz iteracyjnie
//4. Fibonacci n-ty wyraz rekrencyjnie
//5. Silnia n-ta iteracyjnie
//6. Silnia n-ta rekrencyjnie
//7. Algorytm Hornera
//8. Suma cyfr liczby
//9. Liczby pierwsze w przedziale <n, m>
//10.Wypisanie dzielników w przedziału <k, l> liczby x

fun main(){

}
fun EuklidesSub(a: Int, b: Int):Int{
    var x = kotlin.math.abs(a)
    var y = kotlin.math.abs(b)

    if (x == 0) return y
    if (y == 0) return x

    while (x != y) {
        if (x > y) {
            x -= y
        } else {
            y -= x
        }
    }

    return x
}

fun EuklidesMod(a: Int, b: Int): Int{
    var x = kotlin.math.abs(a)
    var y = kotlin.math.abs(b)

    while (y != 0) {
        val r = x % y
        x = y
        y = r
    }

    return x
}