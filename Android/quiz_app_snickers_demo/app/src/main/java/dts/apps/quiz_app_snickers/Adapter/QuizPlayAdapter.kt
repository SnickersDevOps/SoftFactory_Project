package dts.apps.quiz_app_snickers.Adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import dts.apps.quiz_app_snickers.R
import dts.apps.quiz_app_snickers.REST.Data.questionBody.questionBodyItem
import kotlinx.android.synthetic.main.fragment_quiz_play_page.view.*
import kotlinx.android.synthetic.main.quiz_question_list_item.view.*
import kotlin.math.max


class QuizPlayAdapter : RecyclerView.Adapter<QuizPlayAdapter.QuizPlayViewHolder>() {
    var questionList = emptyList<questionBodyItem>()
    var score = 0

    class QuizPlayViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizPlayViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.quiz_question_list_item, parent, false)

        return QuizPlayViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizPlayViewHolder, position: Int) {

        holder.itemView.txt_question?.text = questionList[position].q_text
        holder.itemView.txt_option_one?.text = questionList[position].option_one
        holder.itemView.txt_option_two?.text = questionList[position].option_two
        holder.itemView.txt_option_three?.text = questionList[position].option_three
        holder.itemView.txt_option_four?.text = questionList[position].option_four

        if (position == itemCount - 1) {
            holder.itemView.btn_finish.visibility = (View.VISIBLE)
        }
        holder.itemView.option_group.setOnCheckedChangeListener { radioGroup, i ->
            var rb = holder.itemView.findViewById<RadioButton>(i)
            if (rb.text.toString() == questionList[position].correct_text) {
                score += 1
                Log.i("ew", score.toString())
            }
            val bundle = Bundle()
            bundle.putInt("score", score)
            holder.itemView.btn_finish.setOnClickListener { view ->
                view?.findNavController()?.navigate(R.id.action_quizPlayPage_to_resultPage , bundle)
            }
        }



    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    fun setData(list: List<questionBodyItem>) {
        questionList = list
        notifyDataSetChanged()
    }
}