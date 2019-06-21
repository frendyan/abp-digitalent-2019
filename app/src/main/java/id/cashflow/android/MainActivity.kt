package id.cashflow.android

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.cashflow.android.util.Calculator
import kotlinx.android.synthetic.main.vcs.*


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vcs)

        ivNotification.setOnClickListener{
            Toast.makeText(this@MainActivity, "Notification", Toast.LENGTH_SHORT).show()
        }

        ivGear.setOnClickListener{
            Toast.makeText(this@MainActivity, "Setting", Toast.LENGTH_SHORT).show()
        }

        println("HALO ANDROID !")
        val sum = Calculator().sum( 5 , 6)
        println("Hasil:  ${sum}")

        val sub = Calculator().sub(5,6)
        println("Hasil:  ${sub}")

        val mul = Calculator().mul(5,6)
        println("Hasil:  ${mul}")

        val div = Calculator().div(5,6)
        println("Hasil:  ${div}")    }
}