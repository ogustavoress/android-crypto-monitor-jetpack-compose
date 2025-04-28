package ogustavoress.com.github.android_crypto_monitor

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import ogustavoress.com.github.android_crypto_monitor.R.color.primary

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Configurando a toolbar
        val toolbarMain: Toolbar = findViewById(R.id.toolbar_main)
        configureToolbar(toolbarMain)
    }

    private fun configureToolbar(toolbar: Toolbar){
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(getColor(R.color.white))
        supportActionBar?.setTitle(getColor(R.string.app_title))
        supportActionBar?.setBackgroundDrawable(getDrawable(primary))
    }
}