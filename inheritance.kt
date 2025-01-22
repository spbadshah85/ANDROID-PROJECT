
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(protected var name: String, private var category: String) {
    private var deviceStatus = "off"
    open val deviceType = "unknown"
    open fun turnOn() {
       deviceStatus = "on"
    }
    open fun turnOff() {
        deviceStatus = "off"
    }
   open fun printDeviceInfo() {
        println("Device name : $name\n"+
                "Category : $category\n" +
                "Device Type : $deviceType"
        )
   }
   fun deviceActionStatus() : String {
       return deviceStatus
   }
}

class SmartTvDevice (deviceName: String,deviceCategory: String) :
    SmartDevice(deviceName ,deviceCategory) {
     override val deviceType = "Smart TV"

     private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
     private var channelNumber by RangeRegulator(initialValue = 1, maxValue = 200, minValue = 1)
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber")
    }
    override fun turnOn() {
        // calling parent method with super keyword
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume " +
                "and channel number is set to $channelNumber "
                )

    }
    override fun turnOff() {
        // calling parent method with super keyword
        super.turnOff()
        println("$name turned off")
    }

    override fun printDeviceInfo() {
        println("Device information : ")
        super.printDeviceInfo()
    }

}
class SmartLightDevice(deviceName: String,deviceCategory: String) :
    SmartDevice(deviceName,deviceCategory) {
        override val deviceType = "Smart Light"
        private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println(" $name turned on. The brightness level is $brightnessLevel ")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    override fun printDeviceInfo() {
        println("Device information : ")
        super.printDeviceInfo()
    }
}
class SmartHome(val smartTvDevice: SmartTvDevice,
                val smartLightDevice: SmartLightDevice
) {
    private var deviceTurnOnCount = 0
    fun turnOnTv() {
        if(smartTvDevice.deviceActionStatus()== "off") {
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }
        else{
            println("Your device is already turn on")
        }
    }
    private fun turnOffTv() {
        if(smartTvDevice.deviceActionStatus()== "on") {
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
        else{
            println("Your device is already turn off")
        }
    }
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    fun decreaseTvVolume() {
        smartTvDevice.decreaseVolume()
    }
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    fun changeTvChannelToPrevious() {
        smartTvDevice.previousChannel()
    }
    fun turnOnLight() {
        if (smartLightDevice.deviceActionStatus() == "off") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
        else{
            println("Your device is already turn on")
        }
    }
    private fun turnOffLight() {
        if (smartLightDevice.deviceActionStatus() == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
        else{
            println("Your device is already turn off")
        }
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun decreaseLightBrightness() {
        smartLightDevice.decreaseBrightness()
    }
    fun turnOffAllDevices() {
        turnOffLight()
        turnOffTv()
    }

}

class RangeRegulator(
    initialValue : Int,
    private val minValue : Int,
    private val maxValue : Int
) : ReadWriteProperty<Any?,Int> {
    private var fieldData = initialValue
    override fun getValue(thisRef : Any?, property : KProperty<*>) : Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
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
    smartHome.decreaseLightBrightness()
    smartHome.changeTvChannelToPrevious()
    smartHome.decreaseTvVolume()




}