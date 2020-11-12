package net.tlalka.github.search.feature.projectlist.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import net.tlalka.github.search.databinding.ProjectListFragmentBinding
import net.tlalka.github.search.feature.projectlist.view.adapter.ProjectsAdapter
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewModel
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewModelFactory
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewState
import net.tlalka.github.search.platform.BaseMvvmFragment

class ProjectListFragment : BaseMvvmFragment<ProjectListViewModel, ProjectListFragmentBinding>(
    inflateFunction = ProjectListFragmentBinding::inflate
) {

    private val viewModel: ProjectListViewModel by viewModels { ProjectListViewModelFactory() }

    private val projectsAdapter: ProjectsAdapter = ProjectsAdapter()

    override fun inject() {
        // Not yet implemented
    }

    override fun bind(binding: ProjectListFragmentBinding) {
        binding.viewModel = viewModel

        with(binding.projectListRecycler) {
            layoutManager = LinearLayoutManager(context)
            adapter = projectsAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getViewState().observe(viewLifecycleOwner, Observer(::onViewStateUpdate))
    }

    private fun onViewStateUpdate(viewState: ProjectListViewState) {
        if (projectsAdapter.currentList != viewState.projects) {
            projectsAdapter.submitList(viewState.projects)
        }
    }
}
