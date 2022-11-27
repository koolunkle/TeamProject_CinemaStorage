package kr.or.mrhi.cinemastorage.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kr.or.mrhi.cinemastorage.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply { initView() }
    }

    private fun initView() {
        val handler = Handler(Looper.getMainLooper())
        val intent = Intent(this, MainActivity::class.java)
        handler.postDelayed({
            startActivity(intent)
            finish()
        }, 4000)
    }

}