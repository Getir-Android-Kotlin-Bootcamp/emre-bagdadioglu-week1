import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException

fun main() {

    /***********************************************/
    //9 - Print & Println standart çıktı
    print("Greetings, ")
    print("planet!")
    print("Hello universe!")
    print(23)
    /***********************************************/
    //10 - Fonksiyonlar
    print2(5)
    /***********************************************/
    //11 - Değişkenler
    var myVariable = 5

    /***********************************************/
    //12 - Sınıflar ve örnekler (instances) oluşturma
    var myClass = MyClass()
    var myClass2 = MyClass2()

    /***********************************************/
    //14 - String tanımı
    var myString = "Hello"

    /***********************************************/
    //15 - Koşullu ifadeler
    var myNumber = 10
    if (myNumber > 5) {
        println("Yes")
    } else {
        println("No")
    }
    /***********************************************/
    //16 - For döngüsü
    for (i in 1..5) {
        println(i)
    }
    /***********************************************/
    //17 - While döngüsü
    var i = 1
    while (i <= 5) {
        println(i)
        i++
    }
    /***********************************************/
    //18 - When Kullanımı
    var myNumber2 = 5
    when (myNumber2) {
        1 -> println("One")
        2 -> println("Two")
        3 -> println("Three")
        4 -> println("Four")
        5 -> println("Five")
        else -> println("Unknown")
    }
    /***********************************************/
    //19 - Ranges﻿ Kullanımı
    for (i in 1..5) {
        println(i)
    }
    /***********************************************/
    //20 - Koleksiyonlar
    var myArray = arrayOf(1, 2, 3, 4, 5)
    for (number in myArray) {
        println(number)
    }
    /***********************************************/
    //21 - Null  değerler (Nullable) ve null kontrolleri (null check)
    var myString2: String? = null
    if (myString2 != null) {
        println(myString2)
    } else {
        println("It is null")
    }
    /***********************************************/
    //22 - Tip kontrolleri (type checks) ve otomatik dönüşümler (automatic casts)
    var myAny: Any = 10
    if (myAny is Int) {
        println("It is integer")
    }
    /***********************************************/
    //37 - Idioms (Deyimler) DTO
    data class User(val name: String, val age: Int)

    val user = User("Ali", 30)
    println(user)
    /***********************************************/
    //38 - Idioms (Deyimler) Default  parameters
    fun printMessage(message: String = "Hello") {
        println(message)
    }
    printMessage()
    printMessage("Hi")
    /***********************************************/
    //39 - Idioms (Deyimler) List Filter
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val evenList = list.filter { it % 2 == 0 }
    println(evenList)
    /***********************************************/
    //40 - Idioms (Deyimler) Koleksiyondaki bir öğenin varlığını kontrol etme
    val list2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    if (5 in list2) {
        println("Yes")
    } else {
        println("No")
    }
    /***********************************************/
    //41 - Idioms (Deyimler) Instance checks﻿ (Örnek kontrollleri)
    when (myAny) {
        is Int -> println("It is integer")
        is String -> println("It is string")
        else -> println("Unknown")
    }
    /***********************************************/
    //42 - Idioms (Deyimler) Read-only list﻿ (Salt okunur liste)
    val list3 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(list3)
    /***********************************************/
    //43 - Idioms (Deyimler) Read-only map﻿ (Salt okunur map list)
    val map = mapOf("x" to 1, "y" to 2, "z" to 3)
    println(map)
    /***********************************************/
    //44 - Idioms (Deyimler) Traverse a map or a list of pairs﻿ (map list key value değerlere erişim)
    val map2 = mapOf("x" to 1, "y" to 2, "z" to 3)
    for ((key, value) in map2) {
        println("$key -> $value")
    }
    /***********************************************/
    //45 - Idioms (Deyimler) "lazy property"
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }
    println(lazyValue)
    println(lazyValue)
    /***********************************************/
    //46 - Idioms (Deyimler) Eklenti fonksiyonları (extension functions)
    fun String.removeLastChar(): String = this.substring(0, this.length - 1)
    println("Hello".removeLastChar())
    /***********************************************/
    //47 - Idioms (Deyimler) Singleton
    MySingleton
    /***********************************************/
    //48 - Idioms (Deyimler) Soyut (abstract)
    abstract class MyAbstractClass {
        abstract fun abstractFunction()
    }

    /***********************************************/
    //49 - Idioms (Deyimler) If-not-null shorthand﻿ ( Boş değilse kontrolu kısayolu)
    var myString3: String? = "Hello"
    println(myString3?.length)
    /***********************************************/
    //50 - Idioms (Deyimler) If-not-null-else shorthand﻿ ( Boşsa kısa yolu kontrolu)
    var myString4: String? = null
    println(myString4 ?: "It is null")
    /***********************************************/
    //51 - Idioms (Deyimler) Execute a statement if null﻿ ( Boşsa exception gösterimi)
    var myString5: String? = null
    println(myString5 ?: throw IllegalArgumentException("It is null"))
    /***********************************************/
    //52 - Idioms (Deyimler) Boş bir koleksiyonun ilk ögesine erişim
    val list4 = emptyList<Int>()
    println(list4.firstOrNull())
    /***********************************************/
    //53 - Idioms (Deyimler) Boş değilse çalıştır devam et
    var myString6: String? = "Hello"
    myString6?.let { println(it) }
    /***********************************************/
    //54 - Idioms (Deyimler) null değer ve null olmayan değere erişim. Her iki durumda tanımlama
    var myString7 = "Hello"
    var myString8: String? = null
    println(myString7)
    println(myString8)
    /***********************************************/
    //55 - Idioms (Deyimler) When ifadesi geri döndürme
    fun changeString(myString9: String) = when (myString9) {
        "Hello" -> "Hi"
        "Hi" -> "Hello"
        else -> "Unknown"
    }
    println(changeString("Hello"))
    /***********************************************/
    //56 - Idioms (Deyimler) Try-catch ifadesi
    fun divide(a: Int, b: Int) = try {
        a / b
    } catch (e: ArithmeticException) {
        0
    }
    println(divide(10, 2))
    println(divide(10, 0))
    /***********************************************/
    //58 - Idioms (Deyimler) if ifadesi değerini değişkene atama
    val myNumber3 = 10
    val result = if (myNumber3 > 5) "Yes" else "No"
    println(result)
    /***********************************************/
    //59 - Idioms (Deyimler) Değer döndürken yeniden oluşturma
    fun getNumber(): IntArray {
        return IntArray(6).apply { fill(5) }
    }
    println(getNumber().contentToString())
    /***********************************************/
    //60 - Idioms (Deyimler) Tek ifadeli metodlar
    fun getNumber2() = 5
    println(getNumber2())
    /***********************************************/
    //61 - Idioms (Deyimler) Bir nesne örneğinde birden çok yöntemi çağırın
    class Car {
        fun start() = println("Car started")
        fun stop() = println("Car stopped")
    }

    val car = Car().apply {
        start()
        stop()
    }

    /***********************************************/
    //62 - Idioms (Deyimler) Bir nesnenin özelliklerini yapılandırma
    class Car2 {
        var brand: String = ""
        var model: String = ""
        var year: Int = 0
    }

    val car2 = Car2().apply {
        brand = "BMW"
        model = "X5"
        year = 2020
    }
    println(car2.brand)
    println(car2.model)
    println(car2.year)
    /***********************************************/
    //63 - Idioms (Deyimler) Java 7'nin kaynakları deneme özelliği
    var dosyaYolu: String? = "dosya.txt"
    try {
        BufferedWriter(FileWriter(dosyaYolu)).use { writer ->
            writer.write("Bu bir deneme metnidir.")
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    /***********************************************/
    //64 - Idioms (Deyimler) Generic type kullanımı
    fun <T> printList(list: List<T>) {
        for (item in list) {
            println(item)
        }
    }
    printList(listOf(1, 2, 3, 4, 5))
    printList(listOf("A", "B", "C", "D", "E"))
    /***********************************************/
    //65 - Idioms (Deyimler) Değişkeni değiştirme also fonksiyonu
    var myNumber4 = 5
    myNumber4 = myNumber4.also { it + 5 }
    println(myNumber4)
    /***********************************************/
    //66 - Idioms (Deyimler) Geliştirme sırasında tamamlamadıklarını işaretle (TODO)
    fun myFunction() {
        //TODO("Not implemented yet")
    }

    /***********************************************/
    //67 - Functions Default Parameter Values and Named Arguments
    fun printMessage2(message: String = "Hello", count: Int = 1) {
        for (i in 0 until count) {
            println(message)
        }
    }
    printMessage2("Hi", 5)
    printMessage2(count = 5)
    /***********************************************/
    //68 - Functions Infix Functions
    infix fun Int.plus2(number: Int): Int {
        return this + number
    }
    println(5 plus2 3)
    /***********************************************/
    //69 - Functions Operator Functions
//    operator fun Int.times2(number: Int): Int {
//        return this * number
//    }
//    println(5 times2 3)
    /***********************************************/
    //70 - Functions Functions with vararg Parameters
    fun printAll(vararg messages: String) {
        for (m in messages) {
            println(m)
        }
    }
    printAll("Hello", "Hi", "Merhaba")
    /***********************************************/
    //71 - Variables Variables ( var - mutable  val immutable )
    var myVariable2 = 5
    myVariable2 = 10
    val myVariable3 = 5
    //myVariable3 = 10
    /***********************************************/
    //72 - Null Safety Null Safety
    var myString10: String? = null
    //var length = myString10.length
    if (myString10 != null) {
        var length = myString10.length
    }
    var length = myString10?.length

    /***********************************************/
    //73 - Null Safety
    var myString11: String? = null
    var length2 = myString11?.length ?: 0

    /***********************************************/
    //74 - Classes
    class MyClass3 {
        var myVariable4 = 5
        fun myFunction2() {
            println("Hello")
        }
    }

    var myClass3 = MyClass3()
    println(myClass3.myVariable4)
    myClass3.myFunction2()
    /***********************************************/
    //75 - Generics
    class MyClass4<T>(myVariable5: T) {
        var myVariable6 = myVariable5
    }

    var myClass4 = MyClass4(5)
    var myClass5 = MyClass4("Hello")

    /***********************************************/
    //76 - Generics Generic Functions
    fun <T> printItem(item: T) {
        println(item)
    }
    printItem(5)
    printItem("Hello")
    /***********************************************/
    //77 - Inheritance
    open class MyClass5 {
        open fun myFunction3() {
            println("Hello")
        }
    }

    class MyClass6 : MyClass5() {
        override fun myFunction3() {
            println("Hi")
        }
    }

    var myClass6 = MyClass6()
    myClass6.myFunction3()
    /***********************************************/
    //78 - Inheritance Inheritance with Parameterized Constructor
    open class Car2(val brand: String, val model: String) {
        open fun startEngine() {
            println("$brand $model engine started!")
        }
    }

    class Sedan(model: String) : Car2("Opel", model) // 1

    fun main() {
        val car: Car2 = Sedan("Astra")
        car.startEngine()

        val sedanCar = Sedan("Corsa")
        sedanCar.startEngine()
    }

    /***********************************************/
    //79 - Inheritance Passing Constructor Arguments to Superclass
    open class Car3(val brand: String, val model: String) {
        open fun startEngine() {
            println("$brand $model engine started!")
        }
    }

    class Sedan2(brand: String, model: String) : Car3(brand, model) // 1

    fun main2() {
        val car: Car3 = Sedan2("Opel", "Astra")
        car.startEngine()

        val sedanCar = Sedan2("Opel", "Corsa")
        sedanCar.startEngine()
    }

    /***********************************************/
    //80 - Control Flow When Statement
    fun describe(obj: Any): String =
        when (obj) {
            2 -> "Two"
            "Hi" -> "Merhaba"
            is Int -> "Int"
            !is Long -> "Not a long"
            else -> "Unknown"
        }
    println(describe(2))
    println(describe("Hi"))
    println(describe(5))
    println(describe(5L))
    println(describe("Hello"))
    /***********************************************/
    //81 - Control Flow When Expression
    fun describe2(obj: Any): String = when (obj) {
        2 -> "Two"
        "Hi" -> "Merhaba"
        is Int -> "Int"
        !is Long -> "Not a long"
        else -> "Unknown"
    }
    //82 -Control Flow for loop
    val myArray2 = arrayOf(1, 2, 3, 4, 5)
    for (number in myArray2) {
        println(number)
    }
    /***********************************************/
    //83 - Control Flow while loop
    var i2 = 1
    while (i2 <= 5) {
        println(i2)
        i2++
    }
    /***********************************************/
    //84 - Control Flow do-while loop
    var i3 = 1
    do {
        println(i3)
        i3++
    } while (i3 <= 5)
    /***********************************************/
    //85 - Control Flow Ranges
    for (i in 1..5) {
        println(i)
    }
    /***********************************************/
    //88 - Control Flow Equality Check
    val myNumber5 = 5
    val myNumber10 = 10
    if (myNumber5 == 5) {
        println("Yes")
    } else if(myNumber5 === myNumber10) {
        println("No")
    }
    /***********************************************/
    //89 - Control Flow Conditional Expression
    val myNumber6 = 5
    val result2 = if (myNumber6 > 5) "Yes" else "No"
    println(result2)
    /***********************************************/
    //90 - Special Classes Data Classes
    data class User2(val name: String, val age: Int)
    val user3 = User2("Ali", 30)
    println(user3)
    // add compare
    val user4 = User2("Ali", 30)
    println(user3 == user4)
    /***********************************************/



}


object MySingleton {
    init {
        println("MySingleton is created")
    }
}

fun print2(value: Int) {
    println(value)
}

class MyClass {
    init {
        println("MyClass is created")
    }
}

open class MyClass2 {
    init {
        println("MyClass is created")
    }
}

