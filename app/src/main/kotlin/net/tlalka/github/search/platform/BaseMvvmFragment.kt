package net.tlalka.github.search.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseMvvmFragment<VM : ViewModel, BD : ViewDataBinding>(
    private val inflateFunction: (LayoutInflater) -> BD
) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflateFunction.invoke(inflater).apply {
        bind(binding = this)
        lifecycleOwner = this@BaseMvvmFragment
    }.root

    abstract fun inject()

    abstract fun bind(binding: BD)
}
