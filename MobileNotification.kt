import javax.management.Notification

fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotification(morningNotification)
    printNotification(eveningNotification)
}
fun printNotification(notification: Int) {
    if (notification in 1.. 99) {
        println("You hava $notification notifications.")
    }
    else if (notification >= 100) {
        println("Your phone is blowing up! You have 99+ notifications.")
    }

}