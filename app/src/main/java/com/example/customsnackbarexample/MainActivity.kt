package com.example.customsnackbarexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

//1. 일반 Snackbar
//2. Snackbar에 버턴
//3. snackbar글자에 색깔 입히기
class MainActivity : AppCompatActivity() {
    private lateinit var button_SnackBar : Button
    private lateinit var listener : View.OnClickListener
    private lateinit var coodinatorlayout : CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setMemberVariables()
    }

    private fun setMemberVariables() {
        button_SnackBar = findViewById(R.id.button_snackbar)
        coodinatorlayout = findViewById(R.id.coordinatorlayour)
        buttonClick_listener()
        button_SnackBar.setOnClickListener(listener)
    }

    private fun buttonClick_listener() {
        listener = View.OnClickListener {
            when (it.id) {
                //R.id.button_snackbar -> Toast.makeText(baseContext, "Thanks. You pressed the button", Toast.LENGTH_SHORT).show()
                R.id.button_snackbar -> {
                    val snackBar = Snackbar.make(coodinatorlayout, "You pressed the button", Snackbar.LENGTH_INDEFINITE)
                        .setAction("UNDO", View.OnClickListener {
                            val snackbar1 : Snackbar = Snackbar.make(coodinatorlayout, "Undo successful", Snackbar.LENGTH_LONG)
                            //이렇게 봐도 훨씬 간결한데??? 더 쉽게 보인다. 변수를 쓸 필요도 없고..
                            snackbar1.view.findViewById<TextView?>(com.google.android.material.R.id.snackbar_text).setTextColor(Color.GREEN)
                            snackbar1.show()
                        })
                        .setActionTextColor(Color.RED)
                    val snackView : View = snackBar.view
                    val textView : TextView = snackView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                    textView.setTextColor(Color.YELLOW)
                    snackBar.show()
                }
            }
        }
    }

}