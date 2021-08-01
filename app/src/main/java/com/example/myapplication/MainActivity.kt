package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CHANGE TO .ADD???
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MovieDetailsFragment())
            .commit()
    }

}

