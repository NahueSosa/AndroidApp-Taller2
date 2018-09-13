package ar.uba.fi.tallerii.comprameli

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import ar.uba.fi.tallerii.comprameli.api.root.model.Ping
import ar.uba.fi.tallerii.comprameli.api.root.services.RootServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var btnPong: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnPong = findViewById(R.id.btnPong)

    }

    override fun onResume() {
        super.onResume()
        btnPong.visibility = View.INVISIBLE
    }

    fun doPing(view: View) {
        btnPong.visibility = View.INVISIBLE
        val retroFit: Retrofit = Retrofit.Builder()
                .baseUrl("https://app-server-taller2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retroFit.create<RootServices>(RootServices::class.java)

        service.getPing().enqueue(object: Callback<Ping> {
            override fun onResponse(call: Call<Ping>, response: Response<Ping>) {
                val ping = response.body()
                if (ping != null && ping.isPongOk()!!) {
                    btnPong.visibility = View.VISIBLE;
                } else {
                    showToastText("Error en la comunicacion con App Server")
                }

            }

            override fun onFailure(call: Call<Ping>, t: Throwable) {
                showToastText("No se ha podido pingear el App Server")
            }
        })
    }

    fun showToastText(text:String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
