fun main() {
    val trickFunction1 = trick() // Output
    //trickFunction1()  ERROR because of Return type Unit
    val trickFunction2 = ::trick // No output here
    trickFunction2() // Output
    trick1() // Output
    val trickFunction3 = trick1 // No Output here
    trickFunction3() //  output
    val trickFunction4 = ::trick1 // No Output
    trickFunction4() // No output
    val trickFunction5 = trick1() // Output
     //trickFunction5()  ERROR because of return type
    treat // No output
    treat() // Output
    val trick1Function = trickOrTreat(true) // No Output
    trick1Function() // Output
    val treatFunction = trickOrTreat(false) // No output
     treatFunction() // Output

    //val trick1Function2 = trickOrTreat1(true, coins)  ERROR because of coins is not found

    val coins : (Int) -> String = {
        quantity -> "$quantity quarters"
        // or "$quantity quarters"  is same work
    }
    val coins2: (Int) -> String = {
        "$it quarters"// &it like quantity same work
    }
    val cupcake : (Int) -> String = {
        "Have a cupcake"
    }

    val trick1Function2 = trickOrTreat1(true, coins) // No output here
    trick1Function2() // Output  : No treats 1
    val treatFunction1 = trickOrTreat1(true,cupcake) //  No Output here
    treatFunction1() // Output : No treats 1
    val trick1Function3 = trickOrTreat1(false,coins) // Output : 5 quarters
    trick1Function3() // Output : Have a treat !
    val treatFunction2 = trickOrTreat1(false,cupcake) // Output : have a cupcake
    treatFunction2() // Output : Have a treat !


     // coins and coins_2 replace direct with Lambda expression in argument is possible { "$it quarters"}
      println("By Repeat Function")
     repeat(5) {
         treatFunction2()
     }

    val trick1Function4 = trickOrtreat2(true,coins2) // No output
    trick1Function4() // Output : No treats 1
    val treatFunction3 = trickOrtreat2(true,cupcake) // No output
    treatFunction3() // Output : No treats 1
    val trick1Function5 = trickOrtreat2(false,coins2) // Output : 5 quarters
    trick1Function5() // Have a treat !
    val trick1Function6 = trickOrtreat2(false,null) // No output
    trick1Function6() // Have a treat !
    val treatFunction4 = trickOrtreat2(true,null) // No output
    treatFunction4() // Output : No treats 1


    //trailing  Lambda expression
    val trailing = trickOrtreat2(false) { "$it quarters"} // Output : 5 quarters
    trailing() // Have a treat !

}
fun trick () {
    println("no treats")
}
val trick1 = {
    println("No treats 1")
}
val treat : () -> Unit = { //  "() -> Unit"  is defined data type
    println("Have a treat !")
}
fun trickOrTreat(isTrick : Boolean) : () -> Unit {
    return if (isTrick) {
        trick1  // you can't return trick() function here because type mismatch
    }
    else
    {
        treat
    }
}
fun trickOrTreat1(isTrick: Boolean,extraTreat : (Int) -> String ) : () -> Unit {
    if (isTrick) {
        return trick1  // you can't return trick() function here because type mismatch
    }
    else
    {
        println(extraTreat(5))
        return treat
    }
}
// Nullable extra treat : ((Int) -> String )?
fun trickOrtreat2(isTrick: Boolean,extraTreat : ((Int) -> String) ? ) : () -> Unit {
    if (isTrick) return trick1  // you can't return trick() function here because type mismatch
    if (extraTreat != null) {
        println(extraTreat(5))
    }
    return treat
}