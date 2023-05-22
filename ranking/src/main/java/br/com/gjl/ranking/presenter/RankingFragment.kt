package br.com.gjl.ranking.presenter

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.gjl.ranking.R
import br.com.gjl.ranking.databinding.FragmentRankingBinding
import br.com.gjl.ranking.domain.model.Student
import br.com.gjl.ranking.presenter.adapter.RankingAdapter
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class RankingFragment : Fragment(R.layout.fragment_ranking) {

    private val viewModel by viewModel<RankingViewModel>()

    private lateinit var binding: FragmentRankingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRankingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInterface()
        showStudents()
    }

    private fun showStudents() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.students.observe(viewLifecycleOwner) { listStudents ->
            populateRankingStudents(listStudents)
            populateListStudents(listStudents)
        }

        viewModel.getStudents()
    }

    private fun populateRankingStudents(students: List<Student>) {
        students.createRanking(
            binding.rankingTop3.firstNameStudent,
            binding.rankingTop3.scoreNumberFirstStudentItem,
            binding.rankingTop3.firstGradeLetterStudent,
            binding.rankingTop3.firstGradeNumberStudent,
            binding.rankingTop3.firstProfileImgRanking,
            students,
            0
        )
        students.createRanking(
            binding.rankingTop3.secondNameStudent,
            binding.rankingTop3.scoreNumberSecondStudentItem,
            binding.rankingTop3.secondGradeLetterStudent,
            binding.rankingTop3.secondGradeNumberStudent,
            binding.rankingTop3.secondProfileImgRanking,
            students,
            1
        )
        students.createRanking(
            binding.rankingTop3.thirdNameStudent,
            binding.rankingTop3.scoreNumberThirdStudentItem,
            binding.rankingTop3.thirdGradeLetterStudent,
            binding.rankingTop3.thirdGradeNumberStudent,
            binding.rankingTop3.thirdProfileImgRanking,
            students,
            2
        )
    }

    private fun List<Student>.createRanking(
        firstName: TextView,
        score: TextView,
        gradeLetter: TextView,
        gradeNumber: TextView,
        image: AppCompatImageView,
        student: List<Student>,
        position: Int
    ) {
        context?.let {
            Glide.with(it.applicationContext)
                .load(student[position].image)
                .into(image)
        }

        firstName.text = student[position].firstName
        score.text = student[position].score.toString()
        gradeLetter.text = student[position].gradeLetter
        gradeNumber.text = student[position].gradeNumber.toString().plus("°")
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun populateListStudents(students: List<Student>) {
        val studentsList = students.drop(3) // Obter os demais estudantes

        binding.recyclerView.adapter =
            RankingAdapter(studentsList, requireContext()).apply { notifyDataSetChanged() }
    }

    private fun setupInterface() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = requireActivity().window
            val background = ContextCompat.getDrawable(requireActivity(), R.drawable.gradient)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor =
                ContextCompat.getColor(requireActivity(), android.R.color.transparent)
            window.setBackgroundDrawable(background)
        }
    }
}