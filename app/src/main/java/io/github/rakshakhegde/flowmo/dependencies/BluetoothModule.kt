package io.github.rakshakhegde.flowmo.dependencies

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import com.github.ivbaranov.rxbluetooth.RxBluetooth
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Preferably should be handled with {@link BleBaseInteractionActivity} because
 * the renaming and resetting of name will be handled properly.
 *
 * Created by rakshakhegde on 14/01/17.
 */
class BluetoothModule(val rxBle: RxBluetooth, val bleAdapter: BluetoothAdapter) {

	private val REQUEST_ENABLE_BT = 1
	private var bleName = "MyBle"
	private var isBleOriginallyEnabled = false
	private val randomGen = Random()

	fun enableIfNotAlreadyEnabled(act: Activity) {
		isBleOriginallyEnabled = bleAdapter.isEnabled
		rxBle.apply {
			if (!isBleOriginallyEnabled) {
				enableBluetooth(act, REQUEST_ENABLE_BT)
			}
		}
	}

	fun returnToOriginalState() {
		bleAdapter.name = bleName
		if (!isBleOriginallyEnabled) {
			bleAdapter.disable()
		}
	}

	fun rename() {
		bleName = bleAdapter.name.replace("|", "")

		// Random number upto 10 thousand
		val prefix = randomGen.nextInt(10 * 1000)
		val fmPrefix = "fm$prefix"
		bleAdapter.name = "$fmPrefix|$bleName"
	}

	fun observeName(f: (String) -> Unit) =
			repeatEverySec5Times()
					.observeOn(AndroidSchedulers.mainThread())
					.subscribe { it -> f(bleAdapter.name) }

	fun repeatEverySec5Times() =
			Observable.interval(0, 1, TimeUnit.SECONDS)
					.takeWhile { it < 3 }

}