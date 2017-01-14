package io.github.rakshakhegde.flowmo.receive_screen

import android.os.Bundle
import io.github.rakshakhegde.flowmo.App
import io.github.rakshakhegde.flowmo.BleBaseInteractionActivity
import io.github.rakshakhegde.flowmo.R
import kotlinx.android.synthetic.main.activity_receive.*
import rx.Subscription

class ReceiveActivity : BleBaseInteractionActivity(App.instance.bleModule) {

	private var observeName: Subscription? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_receive)
	}

	override fun onResume() {
		super.onResume()

		observeName = App.instance.bleModule.observeName { name ->
			bleNameTv.text = name
		}
	}

	override fun onPause() {
		super.onPause()
		observeName?.unsubscribe()
	}
}
