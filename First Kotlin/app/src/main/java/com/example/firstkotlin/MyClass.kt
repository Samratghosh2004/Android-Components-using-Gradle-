package com.example.firstkotlin


// IN JAVA
//class MyClass extends ClassA {
// IN KOTLIN
class MyClass : ClassA() {
    companion object{
        @JvmStatic
        //IN JAVA
        // void main(String[] args) {
        // IN KOTLIN
        fun main(args: Array<String>){
            // DATA TYPES
            Int
            Char
            Byte            // In JAVA all the primitive data types are declared in all small letter (like:- int, char, boolean)
                            // and non-primitives are declared as the first letter capital (like :- Array, String)
            Long
            Float           // Here in Kotlin All the data types are declared as the first letter as Capital
            String
            Double
            Boolean


            // VARIABLE
            var a = 7
            var b : Int = 9
            var c : Int
            //Error :===
            // var d (only)
            a = 8

            var x : String = "Samrat"
            println("Hello world $x " + a+" " +b )


            // VAR & VAL
            var w : Int = 10  // normal variable
            val m : Int = 15   // Final variable
            //override
            w = 14
            // But ERROR :== in case of m
            //m =20      (Value of m cannot be changed)
        }
    }
}