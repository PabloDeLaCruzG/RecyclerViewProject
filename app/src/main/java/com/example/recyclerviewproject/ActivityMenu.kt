package com.example.recyclerviewproject

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class ActivityMenu : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        super.onCreateOptionsMenu(menu)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mi_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.goActivity -> {
                Toast.makeText(this, "Has seleccionado Activiada 1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.goActivity2 -> {
                Toast.makeText(this, "Has seleccionado Activiada 2", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}