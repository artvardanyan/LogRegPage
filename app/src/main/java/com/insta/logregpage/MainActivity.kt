package com.insta.logregpage

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.DialogCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.insta.logregpage.databinding.ActivityMainBinding
import com.insta.logregpage.fragments.LogFragment
import com.insta.logregpage.fragments.RegFragment

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.title = "Registration Page"
        binding.toolbar.subtitle = "User"
        binding.toolbar.menu.add("1")
        binding.toolbar.menu.add("2")

        binding.bottomNavigation.setOnNavigationItemSelectedListener(this)
        binding.bottomNavigation.setOnClickListener {

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.help -> {
                //Toast.makeText(this, "Help me", Toast.LENGTH_SHORT).show()
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Help me")
                builder.setMessage("Letter of help")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    Toast.makeText(applicationContext,
                            "Yes", Toast.LENGTH_SHORT).show()
                }

                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(applicationContext,
                            "No", Toast.LENGTH_SHORT).show()
                }

                builder.setNeutralButton("Maybe") { dialog, which ->
                    Toast.makeText(applicationContext,
                            "Maybe", Toast.LENGTH_SHORT).show()
                }
                builder.show()

            }
            R.id.add -> {
                //Toast.makeText(this, "Add Person", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, RegFragment())
                        .addToBackStack(null)
                        .commit()
            }
            R.id.home -> {
                //Toast.makeText(this, "Home Page", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment, LogFragment())
                        .addToBackStack(null)
                        .commit()
            }
        }
        return false
    }

}