package br.com.gjl.ranking.presenter

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.gjl.ranking.R
import br.com.gjl.ranking.databinding.FragmentRankingBinding
import br.com.gjl.ranking.domain.model.Student
import br.com.gjl.ranking.presenter.adapter.RankingAdapter
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
            populateRanking(listStudents)
        }
        viewModel.getStudents()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun populateRanking(students: List<Student>) {
        binding.recyclerView.adapter =
            RankingAdapter(students, requireActivity()).apply { notifyDataSetChanged() }
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