package com.example.estudeaqui.activities

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.estudeaqui.R

class QuizAdapter(val context: Context, val quizzes: List<Quiz>):
    RecyclerView.Adapter<QuizAdapter.QuizViewModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewModel {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false)
        return QuizViewModel(view)
    }

    override fun onBindViewHolder(holder: QuizViewModel, position: Int) {
        holder.textViewTitulo.text = quizzes[position].titulo
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(colorPicked.getColor()))
        holder.iconView.setImageResource(iconPicked.getIcon())
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

    inner class QuizViewModel(itemView: View): RecyclerView.ViewHolder(itemView) {
        var textViewTitulo: TextView = itemView.findViewById(R.id.quizTitle)
        var iconView: ImageView = itemView.findViewById(R.id.quizIcon)
        var cardContainer: CardView = itemView.findViewById(R.id.cardContainer)
    }
}

