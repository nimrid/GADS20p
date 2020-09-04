package com.example.gads20p.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.gads20p.R
import com.example.gads20p.request.FormRequest
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Response

class SubmissionDialog(private val firstName : String, private val lastName : String,
                       private val email : String, private val link : String,
                       val manager : FragmentManager) : DialogFragment() {

    val TAG = "SubmissionDialog"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.confirm_submission, container, false)

            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.setBackgroundDrawableResource(R.drawable.round_dialog)


        val cancelBtn = view.findViewById<ImageView>(R.id.cancel_submission)
        cancelBtn.setOnClickListener {
            dismiss()
        }


        val yesBtn = view.findViewById<MaterialButton>(R.id.yes_btn)
        yesBtn.setOnClickListener {
            val response = FormRequest.invoke().submitProjectForm(firstName, lastName, email, link)
            response.enqueue(object : retrofit2.Callback<Void>{
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.e(TAG, t.message!!)
                    dismiss()
                    CancelDialog().show(manager, TAG)
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Log.i(TAG, response.code().toString())
                    dismiss()
                    if (response.isSuccessful) {
                        SuccessDialog().show(manager, TAG)
                    }
                }

            })
        }

        return view
    }

}
