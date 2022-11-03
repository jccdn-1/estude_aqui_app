package com.example.estudeaqui.activities


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.GridLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.estudeaqui.R
import com.example.estudeaqui.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var gridLayout: GridLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridLayout = binding.mainGrid

        setUpViews()

        clickListener()

    }


    private fun clickListener() {
        val catUm = binding.categoriaUm
        val catDois = binding.categoriaDois
        val catTres = binding.categoriaTres
        val catQuatro = binding.categoriaQuatro

        catUm.setOnClickListener{
            openCategoriaUm()
        }
        catDois.setOnClickListener{
            openCategoriaDois()
        }
        catTres.setOnClickListener{
            openCategoriaTres()
        }
        catQuatro.setOnClickListener{
            openCategoriaQuatro()
        }
    }


    private fun setUpViews() {
        setUpDrawerLayout()
    }

    private fun setUpDrawerLayout() {
        setSupportActionBar(binding.appBar)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.mainDrawer,
            R.string.app_name,
            R.string.app_name
        )
        actionBarDrawerToggle.syncState()
    }


    private fun openCategoriaUm(){

        val intent = Intent(this, CategoriaUmActivity::class.java)

        startActivity(intent)
    }

    private fun openCategoriaDois(){

        val intent = Intent(this, CategoriaDoisActivity::class.java)

        startActivity(intent)
    }

    private fun openCategoriaTres(){

        val intent = Intent(this, CategoriaTresActivity::class.java)

        startActivity(intent)
    }

    private fun openCategoriaQuatro() {

        val intent = Intent(this, CategoriaQuatroActivity::class.java)

        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}