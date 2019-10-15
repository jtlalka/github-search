package net.tlalka.github.search.feature.projectlist.view.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import net.tlalka.github.search.R

object ProjectListBindingAdapter {

    @JvmStatic
    @BindingAdapter("custom_projectSizeInMb")
    fun TextView.projectSizeInMb(sizeInMb: Int) {
        text = resources.getString(R.string.project_list_item_size_in_mb, sizeInMb)
    }
}