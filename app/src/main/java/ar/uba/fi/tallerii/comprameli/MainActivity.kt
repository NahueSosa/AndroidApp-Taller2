package ar.uba.fi.tallerii.comprameli

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ar.uba.fi.tallerii.comprameli.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun showLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
