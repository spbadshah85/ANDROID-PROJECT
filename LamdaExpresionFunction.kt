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
    val coins_2: (Int) -> String = {
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

    val trick1Function_4 = trickOrTreat_2(true,coins_2) // No output
    trick1Function_4() // Output : No treats 1
    val treatFunction_3 = trickOrTreat_2(true,cupcake) // No output
    treatFunction_3() // Output : No treats 1
    val trict1Function_5 = trickOrTreat_2(false,coins_2) // Output : 5 quarters
    trict1Function_5() // Have a treat !
    val trick1Function_6 = trickOrTreat_2(false,null) // No output
    trick1Function_6() // Have a treat !
    val treatFunction_4 = trickOrTreat_2(true,null) // No output
    treatFunction_4() // Output : No treats 1


    //trailing  Lambda expression
    val trailing = trickOrTreat_2(false) { "$it quarters"} // Output : 5 quarters
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
    if (isTrick) {
        return trick1  // you can't return trick() function here because type mismatch
    }
    else
    {
        return treat
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
// Nullable extratreat : ((Int) -> String )?
fun trickOrTreat_2(isTrick: Boolean,extraTreat : ((Int) -> String) ? ) : () -> Unit {
    if (isTrick) {
        return trick1  // you can't return trick() function here because type mismatch
    }
    else
    {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}