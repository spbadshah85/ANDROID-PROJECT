
fun main (){
    val a = hello()
     println(a)
    val  b = ::hello
    b()

}
fun hello(){
    println("Hello")
}