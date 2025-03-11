package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.repayloan

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val buttonClick = findViewById<Button>(R.id.button2)
        buttonClick.setOnClickListener {
            val intent = Intent(this, applyforloan::class.java)
            startActivity(intent)
        }

        val logoutbtn =  findViewById<Button>(R.id.button10)
        logoutbtn.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
        }


        val buttonClick2 = findViewById<Button>(R.id.button3)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, loanstatus::class.java)
            startActivity(intent)
        }

        val buttonprofile = findViewById<Button>(R.id.button7)
        buttonprofile.setOnClickListener {
            val intent = Intent(this, profileview::class.java)
            startActivity(intent)
        }

        val buttonrepay = findViewById<Button>(R.id.button6)
        buttonrepay.setOnClickListener {
            val intent = Intent(this, repayloan::class.java)
            startActivity(intent)
        }


    }
}