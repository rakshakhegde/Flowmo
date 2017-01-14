package io.github.rakshakhegde.flowmo.send_screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.rakshakhegde.flowmo.App
import io.github.rakshakhegde.flowmo.BleBaseInteractionActivity
import io.github.rakshakhegde.flowmo.R

class SendActivity : BleBaseInteractionActivity(App.instance.bleModule) {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_send)
	}
}
