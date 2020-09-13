package ru.ivan.englishdictionary

import android.os.Bundle
import moxy.MvpAppCompatActivity

class HomeActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
