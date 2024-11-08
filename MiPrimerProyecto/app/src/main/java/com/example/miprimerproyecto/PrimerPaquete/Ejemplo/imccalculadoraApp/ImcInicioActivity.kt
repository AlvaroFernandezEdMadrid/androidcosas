package com.example.miprimerproyecto.PrimerPaquete.Ejemplo.imccalculadoraApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimerproyecto.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcInicioActivity : AppCompatActivity() {
    private var isMujer: Boolean = true
    private lateinit var viewHombre: CardView
    private lateinit var viewMujer: CardView
    private lateinit var tvAltura: TextView
    private lateinit var rangeAltura: RangeSlider
    private lateinit var btnPesoMenos: FloatingActionButton
    private lateinit var btnPesoMas: FloatingActionButton
    private lateinit var tvPeso: TextView
    private lateinit var tvEdad: TextView
    private var edadActual: Int = 0
    private var pesoActual: Int = 0
    private lateinit var btnEdadMenos: FloatingActionButton
    private lateinit var btnEdadMas: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_inicio)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarComponentes()
        iniciarListeners()
    }

    private fun iniciarListeners() {
        viewHombre.setOnClickListener {
            toggleGenero(isMujer = false)
        }

        viewMujer.setOnClickListener {
            toggleGenero(isMujer = true)
        }

        rangeAltura.addOnChangeListener { _, value, _ ->
            tvAltura.text = "$value cm"
        }

        btnPesoMas.setOnClickListener {
            actualizarPeso(increment = true)
        }

        btnPesoMenos.setOnClickListener {
            actualizarPeso(increment = false)
        }

        btnEdadMas.setOnClickListener {
            actualizarEdad(increment = true)
        }

        btnEdadMenos.setOnClickListener {
            actualizarEdad(increment = false)
        }
    }


    private fun actualizarEdad(increment: Boolean) {
        edadActual = if (increment) edadActual + 1 else maxOf(0, edadActual - 1)
        tvEdad.text = edadActual.toString()
    }

    private fun actualizarPeso(increment: Boolean) {
        pesoActual = if (increment) pesoActual + 1 else maxOf(0, pesoActual - 1)
        tvPeso.text = pesoActual.toString()
    }

    private fun toggleGenero(isMujer: Boolean) {
        this.isMujer = isMujer
        setGeneroColor()
    }

    private fun setGeneroColor() {
        val mujerSelectedColor = getBackgroundColor(isMujer)
        val hombreSelectedColor = getBackgroundColor(!isMujer)
        viewMujer.setCardBackgroundColor(mujerSelectedColor)
        viewHombre.setCardBackgroundColor(hombreSelectedColor)
    }

    private fun getBackgroundColor(isMujer: Boolean): Int {
        val colorRes = if (isMujer) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorRes)
    }

    private fun iniciarComponentes() {
        viewMujer = findViewById(R.id.cardViewMujer)
        viewHombre = findViewById(R.id.cardViewHombre)
        tvAltura = findViewById(R.id.tvAltura)
        rangeAltura = findViewById(R.id.rangeAltura)
        btnPesoMas = findViewById(R.id.btnPesoMas)
        btnPesoMenos = findViewById(R.id.btnPesoMenos)
        btnEdadMas = findViewById(R.id.btnEdadMas)
        btnEdadMenos = findViewById(R.id.btnEdadMenos)
        tvPeso = findViewById(R.id.tvPeso)
        tvEdad = findViewById(R.id.tvEdad)
    }
}
