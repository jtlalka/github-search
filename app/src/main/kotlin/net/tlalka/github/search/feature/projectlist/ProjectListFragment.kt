package net.tlalka.github.search.feature.projectlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import net.tlalka.github.search.databinding.ProjectListFragmentBinding.inflate
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewModel
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewModelFactory

class ProjectListFragment : Fragment() {

    private val viewModel: ProjectListViewModel by viewModels { ProjectListViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflate(inflater).apply {
        lifecycleOwner = this@ProjectListFragment
        viewModel = this@ProjectListFragment.viewModel
    }.root
}
