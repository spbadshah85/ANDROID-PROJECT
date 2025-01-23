class SongCatalog (
    private val title : String? = null,
    private val artist : String? = null,
    private val publishYear : Int? = null
) {
    private var playCount : Int? = 0
    private var popularSong : Boolean = false

    fun printSongDescription() {
        println("$title, performed by $artist, was released in $publishYear")

    }
    fun play() {
        playCount = playCount!! + 1
        if (playCount!! >= 1000) {
            popularSong = true

        }
    }
}

fun main() {
    val song = SongCatalog("shila hua ka ","Mani miraj",2022)
    song.play()
    song.printSongDescription()

}