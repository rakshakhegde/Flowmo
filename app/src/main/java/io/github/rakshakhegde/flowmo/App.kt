package io.github.rakshakhegde.flowmo

import android.app.Application
import android.bluetooth.BluetoothAdapter
import com.github.ivbaranov.rxbluetooth.RxBluetooth
import io.github.rakshakhegde.flowmo.dependencies.BluetoothModule
import org.jetbrains.anko.ctx

/**
 * Created by rakshakhegde on 14/01/17.
 */
class App : Application() {

	companion object {
		lateinit var instance: App
			private set
	}

	val rxBle by lazy { RxBluetooth(ctx) }

	val bleAdapter = BluetoothAdapter.getDefaultAdapter()

	val bleModule by lazy {
		BluetoothModule(
				rxBle,
				bleAdapter
		)
	}

	override fun onCreate() {
		super.onCreate()
		instance = this
	}
}