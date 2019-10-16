package net.tlalka.github.search.feature.projectlist.view.binding

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView
import net.tlalka.github.search.R

object ProjectListBindingAdapter {

    @JvmStatic
    @BindingAdapter("custom_toggle")
    fun View.toggle(isToggle: Boolean?) {
        visibility = if (isToggle == true) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("custom_projectItemMarker")
    fun MaterialCardView.projectItemMarker(isSelected: Boolean) {
        isActivated = isSelected
    }

    @JvmStatic
    @BindingAdapter("custom_projectSizeInMb")
    fun TextView.projectSizeInMb(sizeInMb: Int) {
        text = resources.getString(R.string.project_list_item_size_in_mb, sizeInMb)
    }
}