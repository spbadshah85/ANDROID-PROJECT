open class SmartDevice(protected var name: String, private var category: String) {
    var deviceStatus = "online"
    open fun turnOn() {
     println(category)
    }
    open fun turnOff() {
     // fun
    }
}
 class SmartTvDevice (deviceName: String,deviceCategory: String) :
    SmartDevice(deviceName ,deviceCategory) {
    private var speakerVolume : Int = 2
        set(value){
            if (value in 0..100){
                field = value
            }
            println(value)
        }
    private var channelNumber : Int = 1
        set(value){
            if (value in 1..200) {
                field = value
            }
        }
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }
    override fun turnOn() {
        deviceStatus = "on"
        println("$name is turned on. Speaker volume is set to $speakerVolume " +
                "and channel number is set to $channelNumber "
                )

    }
    override fun turnOff() {
        deviceStatus = "off"
        println("$name turned off")
    }

}
class SmartLightDevice(deviceName: String,deviceCategory: String) :
    SmartDevice(deviceName,deviceCategory) {
    private var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }

    override fun turnOn() {
        super.turnOn()
        deviceStatus = "on"
        brightnessLevel = 2
        println(" $name turned on. The brightness level is $brightnessLevel ")
    }

    override fun turnOff() {
        deviceStatus = "on"
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}
class SmartHome(val smartTvDevice: SmartTvDevice,
                val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevice.turnOn()
    }
    private fun turnOffTv() {
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    fun turnOnLight() {
        smartLightDevice.turnOn()
    }
    private fun turnOffLight() {
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevices() {
        turnOffLight()
        turnOffTv()
    }
}
fun main () {
    val smartTvDevice = SmartTvDevice("Android TV","Entertainment")
    //smartDevice.turnOn()


    //smartDevice = SmartLightDevice("Google Light","Utility")
    //smartDevice.turnOn()

    val smartLightDevice = SmartLightDevice("LED","Utility")
    //smartLightDevice.turnOn()
   // smartLightDevice.increaseBrightness()
    //smartLightDevice.turnOff()
    //smartLightDevice.increaseBrightness()
    //smartLightDevice.turnOn()
   //println(smartLightDevice.brightnessLevel)
   // smartLightDevice.increaseBrightness()
    val smartHome = SmartHome(smartTvDevice,smartLightDevice)
    smartHome.turnOnLight()
    smartHome.turnOnTv()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    smartHome.increaseTvVolume()
    smartHome.turnOffAllDevices()
    println()
    smartHome.smartTvDevice.turnOn()
    smartHome.smartTvDevice.turnOff()
    smartHome.smartLightDevice.turnOn()
    smartHome.smartLightDevice.turnOff()

    for (num in 1..105) {
        smartHome.increaseTvVolume()
        println(num)
    }


}