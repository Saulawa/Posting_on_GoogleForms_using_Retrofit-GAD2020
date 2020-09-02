package com.saulawa.diary.andelachallenge2020

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_add.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val toolbar: MaterialToolbar = findViewById(R.id.addactivitytoolbar)

        setSupportActionBar(toolbar)

        val successDialog = Dialog(this)

        successDialog.setContentView(R.layout.successdialoglayout)
        successDialog.setTitle("Successful")

        val errorDialog = Dialog(this)

        errorDialog.setContentView(R.layout.errordialoglayout)
        errorDialog.setTitle("Error")





        submitbutton.setOnClickListener {

            val retrofit = Retrofit.Builder()
                .baseUrl(submissionbaseurl)
                .build()

            val postFormService = retrofit.create(APIInterfacePostFormData::class.java)

            if (!TextUtils.isEmpty(firstname.text?.trim().toString()) &&
                !TextUtils.isEmpty(lastname.text?.trim().toString()) &&
                !TextUtils.isEmpty(emailaddress.text?.trim().toString()) &&
                !TextUtils.isEmpty(projectlink.text?.trim().toString())
            ) {

                var _firstname = firstname.text.toString()
                var _lastname = lastname.text.toString()
                var _emailaddress = emailaddress.text.toString()
                var _projectlink = projectlink.text.toString()


                var alert: AlertDialog.Builder = AlertDialog.Builder(this)

                alert.setPositiveButton("Are you sure?", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        postFormService.postForm(_firstname, _lastname, _emailaddress, _projectlink)
                            ?.enqueue(object : Callback<Void?> {
                                override fun onFailure(call: Call<Void?>, t: Throwable) {
                                    errorDialog.show()
                                }

                                override fun onResponse(
                                    call: Call<Void?>,
                                    response: Response<Void?>
                                ) {

                                    successDialog.show();
                                }


                            })
                    }

                })


            } else{

                Toast.makeText(this,"Invalid form data", Toast.LENGTH_SHORT).show()
            }


        }
    }
}