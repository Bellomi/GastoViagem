package com.example.gastodeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this) //this seria a nossa main activity que eu falei que vai se comportar exatamente igual a um OnClickListener que eu coloquei la em cima em View.OnClickListener

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOK()) {

            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                textTotalValue.text = "R$ ${"%.2f".format(totalValue)}" //duas casas decimais depois da virgula

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG).show()
            //criação de uma notificação para o usuário pra informar que ele precisa preencher um campo
        }
    }

    private fun validationOK(): Boolean {
        return (editDistance.text.toString() != " "
                && editPrice.text.toString() != " "
                && editAutonomy.text.toString() != " "
                && editAutonomy.text.toString() != "0")
    }
}
