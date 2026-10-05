package com.kevin.latihan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtRole: TextView

    /*
     * Digunakan untuk menerima hasil dari RoleActivity.
     */
    private val roleLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val selectedRole =
                    result.data?.getStringExtra("selected_role")

                if (selectedRole != null) {
                    txtRole.text = selectedRole
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        // ==============================
        // FIND VIEW
        // ==============================

        val emailContainer =
            findViewById<LinearLayout>(R.id.emailContainer)

        val phoneContainer =
            findViewById<LinearLayout>(R.id.phoneContainer)

        val roleContainer =
            findViewById<LinearLayout>(R.id.roleContainer)

        txtRole =
            findViewById(R.id.txtRole)


        // ==============================
        // EMAIL
        // ==============================

        emailContainer.setOnClickListener {

            val emailIntent = Intent(
                Intent.ACTION_SENDTO
            )

            emailIntent.data =
                Uri.parse("mailto:sarah@school.edu")

            startActivity(emailIntent)
        }


        // ==============================
        // PHONE
        // ==============================

        phoneContainer.setOnClickListener {

            val phoneIntent = Intent(
                Intent.ACTION_DIAL
            )

            phoneIntent.data =
                Uri.parse("tel:+15559876547")

            startActivity(phoneIntent)
        }


        // ==============================
        // ROLE
        // ==============================

        roleContainer.setOnClickListener {

            val intent =
                Intent(this, RoleActivity::class.java)

            /*
             * Kirim role saat ini ke halaman Role.
             */
            intent.putExtra(
                "current_role",
                txtRole.text.toString()
            )

            roleLauncher.launch(intent)
        }
    }
}