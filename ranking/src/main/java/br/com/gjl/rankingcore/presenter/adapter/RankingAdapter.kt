package br.com.gjl.rankingcore.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gjl.rankingcore.R
import br.com.gjl.rankingcore.databinding.ItemStudentListBinding
import br.com.gjl.rankingcore.domain.model.Student
import com.bumptech.glide.Glide

class RankingAdapter(private val student: List<Student>, val context: Context) :
    RecyclerView.Adapter<RankingAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView =
            ItemStudentListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = student[position]

        with(holder) {
            binding.apply {
                firstNameStudentItem.text = item.firstName
                lastNameStudent.text = item.lastName
                gradeNumberStudentItem.text = item.gradeNumber.toString().plus("°")
                gradeLetterStudentItem.text = item.gradeLetter
                scoreNumberStudentItem.text = item.score.toString()
                scoreStudentText.text = context.getString(R.string.score_student)
                imgRankingDetail.let {
                    Glide.with(context.applicationContext)
                        .load(item.image)
                        .into(imgRankingDetail)
                }

            }
        }
    }

    override fun getItemCount() = student.size

    inner class StudentViewHolder(val binding: ItemStudentListBinding) :
        RecyclerView.ViewHolder(binding.root)

}
