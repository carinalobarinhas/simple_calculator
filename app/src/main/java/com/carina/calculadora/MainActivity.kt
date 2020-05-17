package com.carina.calculadora

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var primeiro_numero: Int = -1
    private var segundo_numero: Int = -1
    private var operacao: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao_0.setOnClickListener {
            exibeNumero(0)
        }

        botao_1.setOnClickListener {
            exibeNumero(1)
        }

        botao_2.setOnClickListener {
            exibeNumero(2)
        }

        botao_3.setOnClickListener {
            exibeNumero(3)
        }

        botao_4.setOnClickListener {
            exibeNumero(4)
        }

        botao_5.setOnClickListener {
            exibeNumero(5)
        }

        botao_6.setOnClickListener {
            exibeNumero(6)
        }

        botao_7.setOnClickListener {
            exibeNumero(7)
        }

        botao_8.setOnClickListener {
            exibeNumero(8)
        }

        botao_9.setOnClickListener {
            exibeNumero(9)
        }

        botao_divisao.setOnClickListener {
            exibeOperacao("/")
        }

        botao_multiplicacao.setOnClickListener {
            exibeOperacao("x")
        }

        botao_subtracao.setOnClickListener {
            exibeOperacao("-")
        }

        botao_soma.setOnClickListener {
            exibeOperacao("+")
        }

        botao_igual.setOnClickListener {
            exibeResultado()
        }

        limpar.setOnClickListener {
            primeiro_numero = -1
            segundo_numero = -1
            operacao = "";
            resultado.text = ""
        }
    }

    fun exibeNumero(numero: Int) {
        if (this.operacao.isEmpty()) {
            this.primeiro_numero = numero
            resultado.text = primeiro_numero.toString()
        } else {
            this.segundo_numero = numero
            resultado.text = "$primeiro_numero $operacao $segundo_numero"
        }
    }

    fun exibeOperacao(operacao: String) {
        if (this.primeiro_numero != -1) {
            if(this.operacao.isEmpty()) {
                this.operacao = operacao;
                resultado.text = "$primeiro_numero $operacao";
            }else{
                Toast.makeText(this, "Selecione um número agora", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this, "Selecione um número antes de um operação", Toast.LENGTH_LONG).show()
        }
    }

    fun exibeResultado() {
        if(this.primeiro_numero != -1 && this.operacao.isNotEmpty() && this.segundo_numero != -1){
            var valor = 0
            when(operacao){
                "+" -> valor = primeiro_numero + segundo_numero
                "-" -> valor = primeiro_numero - segundo_numero
                "x" -> valor = primeiro_numero * segundo_numero
                "/" -> valor = primeiro_numero / segundo_numero
            }
            resultado.text = "$primeiro_numero $operacao $segundo_numero = $valor"
        }else{
            Toast.makeText(this, "Impossível encontrar resultado", Toast.LENGTH_LONG).show()
        }
    }
}
