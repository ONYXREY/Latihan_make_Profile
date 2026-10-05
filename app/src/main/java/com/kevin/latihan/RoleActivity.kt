package com.kevin.latihan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_role)


        // ==============================
        // FIND BUTTON
        // ==============================

        val btnAdmin =
            findViewById<Button>(R.id.btnAdmin)

        val btnUser =
            findViewById<Button>(R.id.btnUser)

        val btnGuest =
            findViewById<Button>(R.id.btnGuest)

        val btnBack =
            findViewById<ImageButton>(R.id.btnBackRole)


        // ==============================
        // ADMIN
        // ==============================

        btnAdmin.setOnClickListener {

            selectRole("Admin")
        }


        // ==============================
        // USER
        // ==============================

        btnUser.setOnClickListener {

            selectRole("User")
        }


        // ==============================
        // GUEST
        // ==============================

        btnGuest.setOnClickListener {

            selectRole("Guest")
        }


        // ==============================
        // BACK
        // ==============================

        btnBack.setOnClickListener {

            finish()
        }
    }


    private fun selectRole(role: String) {

        /*
         * Kirim role yang dipilih
         * kembali ke MainActivity.
         */

        val resultIntent = Intent()

        resultIntent.putExtra(
            "selected_role",
            role
        )

        setResult(
            RESULT_OK,
            resultIntent
        )

        finish()
    }
}