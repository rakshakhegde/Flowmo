package io.github.rakshakhegde.flowmo

import android.support.v7.app.AppCompatActivity
import io.github.rakshakhegde.flowmo.dependencies.BluetoothModule
import org.jetbrains.anko.act

/**
 * Created by rakshakhegde on 14/01/17.
 */
abstract class BleBaseInteractionActivity(val bleModule: BluetoothModule) : AppCompatActivity() {


	override fun onResume() {
		super.onResume()

		bleModule.apply {
			rename()
			enableIfNotAlreadyEnabled(act)
		}
	}

	override fun onPause() {
		super.onPause()
		bleModule.returnToOriginalState()
	}
}