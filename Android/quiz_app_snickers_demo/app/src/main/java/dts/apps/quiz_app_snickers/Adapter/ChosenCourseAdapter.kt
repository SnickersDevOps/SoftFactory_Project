package dts.apps.quiz_app_snickers.Adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dts.apps.quiz_app_snickers.MainActivity
import dts.apps.quiz_app_snickers.R
import dts.apps.quiz_app_snickers.REST.Data.quizByCourse.quizByCourseItem
import dts.apps.quiz_app_snickers.screens.QuizPlayPage
import kotlinx.android.synthetic.main.quiz_list_item.view.*
import kotlinx.coroutines.NonDisposableHandle.parent

class ChosenCourseAdapter : RecyclerView.Adapter<ChosenCourseAdapter.ChosenCourseViewHolder>() {
    var quizList = emptyList<quizByCourseItem>()

    class ChosenCourseViewHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChosenCourseViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.quiz_list_item, parent, false)
        return ChosenCourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChosenCourseViewHolder, position: Int) {
        holder.itemView.btn_quiz_name.text = quizList[position].name
        val bundle = Bundle()
        bundle.putInt("quiz_id" , quizList[position].id)
        holder.itemView.btn_quiz_name.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_chosenCoursePage_to_quizPlayPage , bundle)
        }

    }




    override fun getItemCount(): Int {
        return quizList.size
    }

    fun setData(list: List<quizByCourseItem>) {
        quizList = list
        notifyDataSetChanged()
    }

}