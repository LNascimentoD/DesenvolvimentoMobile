package com.example.entrega1

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.annotation.MenuRes

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var audio: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mountSpinner()
        mountPopUpMenu()
        mountLongPress()
        showBackgroundImage()
        switchActivity()
        playAudio()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    private fun mountSpinner() {
        val spinner: Spinner = findViewById(R.id.spinner)

        spinner!!.setOnItemSelectedListener(this)

        val pessoas: Array<String> = resources.getStringArray(R.array.pessoas)
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, pessoas)

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner!!.setAdapter(aa)
    }

    private fun mountPopUpMenu() {
        val showMenuButton: Button = findViewById(R.id.button_dropdown)
        showMenuButton.setOnClickListener { view: View ->
            val popupmenu: PopupMenu = PopupMenu(this, view)
            popupmenu.menuInflater.inflate(R.menu.popup_menu, popupmenu.menu)

            popupmenu.show()
        }
    }

    private fun mountLongPress() {
        val longPressTextView: TextView = findViewById(R.id.textView_longpress)
        longPressTextView.setOnLongClickListener {
            Toast.makeText(this, "TextView foi pressionado longamente", Toast.LENGTH_SHORT).show()
            true
        }
    }

    private fun showBackgroundImage() {
        val btnShowScreeWithBackgroundImage: Button = findViewById(R.id.button_img)
        btnShowScreeWithBackgroundImage.setOnClickListener { view: View ->
            val screnWithBackgroundImage = Intent(this,  ActivityImg::class.java)
            startActivity(screnWithBackgroundImage)
        }
    }

    private fun switchActivity(){
        val btnNavigationActivity_2: Button = findViewById(R.id.button_navigation)
        btnNavigationActivity_2.setOnClickListener{
            val activity_2 = Intent(this, Activity_2::class.java)
            startActivity(activity_2)
        }
    }

    private fun playAudio() {
        audio = MediaPlayer.create(this, R.raw.leilao_boi)
        val play: ToggleButton = findViewById(R.id.button_som)

        play.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                audio.start()
            } else {
                audio.pause()
            }
        }
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
    }
}