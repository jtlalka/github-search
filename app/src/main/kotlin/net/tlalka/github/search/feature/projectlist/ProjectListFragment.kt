package net.tlalka.github.search.feature.projectlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import net.tlalka.github.search.databinding.ProjectListFragmentBinding.inflate
import net.tlalka.github.search.feature.projectlist.adapter.ProjectsAdapter
import net.tlalka.github.search.feature.projectlist.model.ProjectListState
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewModel
import net.tlalka.github.search.feature.projectlist.viewmodel.ProjectListViewModelFactory
import kotlinx.android.synthetic.main.project_list_fragment.project_list_recycler as projectListRecycler

class ProjectListFragment : Fragment() {

    private val viewModel: ProjectListViewModel by viewModels { ProjectListViewModelFactory() }

    private val projectsAdapter: ProjectsAdapter = ProjectsAdapter()

    private val projectListStateObserver = Observer<ProjectListState> {
        projectsAdapter.submitList(it.results)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getProjectListState().observe(this, projectListStateObserver)
        viewModel.searchByQuery("tetris")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflate(inflater).apply {
        lifecycleOwner = this@ProjectListFragment
        viewModel = this@ProjectListFragment.viewModel
    }.apply {
        with(projectListRecycler) {
            layoutManager = LinearLayoutManager(context)
            adapter = projectsAdapter
        }
    }.root
}
