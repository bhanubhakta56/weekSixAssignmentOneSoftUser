package com.vanuvakta.weeksixassignmentone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tv_error:TextView
    private lateinit var et_username:EditText
    private lateinit var et_password:EditText
    private lateinit var btn_login: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv_error = findViewById(R.id.tv_error)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        btn_login = findViewById(R.id.btn_login)
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_login->{
                if (validation()){
                    if(et_username.text.toString().trim()=="softwarica"){
                        if (et_password.text.toString().trim()=="coventry"){
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            tv_error.text="Incorrect Password please double-check your password and try again"
                        }
                    }
                    else{
                        tv_error.text="Invalid Username"
                    }
                }
            }
        }
    }
    fun validation():Boolean{
        if (et_username.text.toString()==""){
            et_username.error="Please enter Username"
            et_username.isFocusable()
            return false
        }
        if (et_password.text.toString()==""){
            if (et_username.text.toString()==""){
                et_username.error="Please enter Username"
                return false
            }
            else{
                et_password.error="Please enter Your Password"
                return false
            }
        }
        return true
    }
}