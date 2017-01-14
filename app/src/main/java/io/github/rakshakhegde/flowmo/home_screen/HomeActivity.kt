package io.github.rakshakhegde.flowmo.home_screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.rakshakhegde.flowmo.R
import io.github.rakshakhegde.flowmo.receive_screen.ReceiveActivity
import io.github.rakshakhegde.flowmo.send_screen.SendActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_home)

		sendBtn.onClick { startActivity<SendActivity>() }
		receiveBtn.onClick { startActivity<ReceiveActivity>() }
	}
}
