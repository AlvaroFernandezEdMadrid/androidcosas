package com.example.aplicaciontareas

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    private val categorias = listOf(
        TareasCategorias.Negocios,
        TareasCategorias.Personal,
        TareasCategorias.Otros
    )

    private val tareas = mutableListOf(
        Tarea("Prueba negocio", TareasCategorias.Negocios),
        Tarea("Prueba otros", TareasCategorias.Otros),
        Tarea("Prueba personal", TareasCategorias.Personal)
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var categoriasAdapter: CategoriasAdapter
    private lateinit var rvTareas: RecyclerView
    private lateinit var tareasAdapter: TareasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponent()
        initUI()


    }

    private fun initUI() {
        categoriasAdapter = CategoriasAdapter(categorias)
        rvCategorias.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter = categoriasAdapter
        tareasAdapter = TareasAdapter(tareas){position->onItemSelected(position)}
        rvTareas.layoutManager = LinearLayoutManager(this)
        rvTareas.adapter = tareasAdapter
    }

    private fun actualizarTarea(){
        tareasAdapter.notifyDataSetChanged()
    }

    private fun initComponent() {
        rvCategorias = findViewById(R.id.rvCategorias)
        rvTareas = findViewById(R.id.rvTareas)
    }

    private fun onItemSelected(position: Int) {
        tareas[position].isSelected=!tareas[position].isSelected
        actualizarTarea()
    }
}