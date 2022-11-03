package com.example.estudeaqui.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.estudeaqui.R
import com.google.firebase.firestore.FirebaseFirestore


class CategoriaUmActivity : AppCompatActivity() {

    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()
    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_um)
        populateDummyData()
        setUpRecyclerView()
        setUpFireStore()

    }

    private fun setUpFireStore() {
        firestore = FirebaseFirestore.getInstance()
        val collectionReference = firestore.collection("quizzes")
    }

    private fun populateDummyData() {
        quizList.add(Quiz("1", "chuu petista"))
        quizList.add(Quiz("2", "chuu petista"))
        quizList.add(Quiz("3", "chuu petista"))
        quizList.add(Quiz("4", "chuu petista"))
        quizList.add(Quiz("5", "chuu petista"))
        quizList.add(Quiz("6", "chuu petista"))
    }

    private fun setUpRecyclerView() {
        val quizRecyclerView = findViewById<RecyclerView>(R.id.quizRecyclerView)
        adapter = QuizAdapter(this, quizList)

        quizRecyclerView.layoutManager = GridLayoutManager(this, 2)
        quizRecyclerView.adapter = adapter
    }
}
