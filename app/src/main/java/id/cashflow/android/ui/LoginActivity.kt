package id.cashflow.android.ui

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import id.cashflow.android.BuildConfig
import id.cashflow.android.R
import id.cashflow.android.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    companion object {
        const val PREF_EMAIL = "user_email"
        const val PREF_NAME = BuildConfig.APPLICATION_ID

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkIsAuthenticated()
        setContentView(R.layout.activity_login)
        initView()
    }

    private val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    private fun checkIsAuthenticated() {

        val userEmail = sharedPref.getString(PREF_EMAIL, null)

        if (userEmail != null){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    private fun initView() {
        btnLogin.setOnClickListener {
            doLogin()
        }
    }

    private fun doLogin() {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        if (authenticated(email,password)){
//simpan ke shared pref: email dengan key user_email
//buka main activity
//versi biasa -> sharedPref.edit().putString(PREF_EMAIL, email).apply()
            
            /*versi ktx*/
            sharedPref.edit {
                putString(PREF_EMAIL, email)
            }

            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }else{
            //muncul error email atau password salah
            toast(getString(R.string.msg_login_failed))

        }
    }

    private fun authenticated(email: String, password: String): Boolean {
        //mencocokan email dan password yang diinput user dengan yang di strings.xml
        return email.equals(getString(R.string.user_email)) && password.equals(getString(R.string.user_password))
    }
}