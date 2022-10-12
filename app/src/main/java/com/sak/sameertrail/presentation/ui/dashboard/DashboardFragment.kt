package com.sak.sameertrail.presentation.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sak.sameertrail.data.utils.isNetworkAvailable
import com.sak.sameertrail.data.utils.makeToast
import com.sak.sameertrail.databinding.FragmentDashboardBinding
import com.sak.sameertrail.presentation.adapters.ParentItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DashboardFragment : Fragment() {

    @Inject lateinit var viewModel: DashboardViewModel
    lateinit var dashboardBinding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.sak.sameertrail.R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardBinding = FragmentDashboardBinding.bind(view)
        dashboardBinding.parentRecyclerview
        val layoutManager = LinearLayoutManager(
            requireContext()
        )

        if (requireActivity().isNetworkAvailable()) viewModel.getData() else  requireContext().makeToast("Please make sure you have stable internet connection")

        viewModel.loading.observe(viewLifecycleOwner) {
            requireContext().makeToast(it)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            requireContext().makeToast(it)
        }
        viewModel.success.observe(viewLifecycleOwner) {
            requireContext().makeToast("Success")
            val parentItemAdapter = ParentItemAdapter(
               it,requireContext()
            )
            dashboardBinding.parentRecyclerview.adapter = parentItemAdapter
            dashboardBinding.parentRecyclerview.layoutManager = layoutManager
        }
    }

}
