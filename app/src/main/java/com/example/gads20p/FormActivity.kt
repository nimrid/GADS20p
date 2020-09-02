package com.example.gads20p

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.DialogFragment
import com.example.gads20p.dialog.SubmissionDialog
import com.example.gads20p.request.FormRequest
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.confirm_submission.*
import retrofit2.Call
import retrofit2.Response

class FormActivity : AppCompatActivity() {

    val TAG = "FormActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        toolbar_nav.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar_nav.setNavigationOnClickListener {
            onBackPressed()
        }

        submit_btn.setOnClickListener {
            validateData()
        }


    }

    private fun validateData() {

        when {
            edit_first_name.text.isEmpty() -> {
                edit_first_name.requestFocus()
                edit_first_name.error = "Field required"
            }
            edit_last_name.text.isEmpty() -> {
                edit_last_name.requestFocus()
                edit_last_name.error = "Field required"
            }
            edit_email.text.isEmpty() -> {
                edit_email.requestFocus()
                edit_email.error = "Field required"
            }
            edit_project_link.text.isEmpty() -> {
                edit_project_link.requestFocus()
                edit_project_link.error = "Field required"
            }
            else -> SubmissionDialog(edit_first_name.text.toString(), edit_last_name.text.toString(),
                edit_email.text.toString(), edit_project_link.text.toString(), supportFragmentManager)
                .show(supportFragmentManager, TAG)
        }



    }



}
