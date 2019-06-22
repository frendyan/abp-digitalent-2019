package id.cashflow.android.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuInflater
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.cashflow.android.R
import kotlinx.android.synthetic.main.vcs.*


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //custom toolbar
        setSupportActionBar(toolbar)

        //method untuk UI
        initView()
        //method untuk Fragment
        initFragment()
    }

    private fun initFragment() {
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, mainFragment)
            .commit()
    }

    private fun initView() {

        ivNotification.setOnClickListener{
            Toast.makeText(this@MainActivity, "Notification", Toast.LENGTH_SHORT).show()
        }

        //Popup menu
        ivGear.setOnClickListener{ view ->
            val popup = PopupMenu(this@MainActivity, view)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu_main_setting, popup.menu)
            popup.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.action_setting -> {
                        Toast.makeText(this@MainActivity, "Setting", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_logout -> {
                    onLogoutClick()
                    true
                }
                    else -> super.onOptionsItemSelected(it)
                }
            }
            popup.show()
        }
    }

    private fun onLogoutClick() {
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        finish()


    }

}