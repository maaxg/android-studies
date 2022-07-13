package com.example.loginapp

import android.R
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val modalBottomSheet = ModalBottomSheet()
        modalBottomSheet.isCancelable = false
        val behavior = BottomSheetBehavior.from(findViewById(R.id.standard_bottom_sheet))
        behavior.peekHeight = newHeight
        modalBottomSheet.show(supportFragmentManager, ModalBottomSheet.TAG)

        setContentView(R.layout.activity_main)
    }
}