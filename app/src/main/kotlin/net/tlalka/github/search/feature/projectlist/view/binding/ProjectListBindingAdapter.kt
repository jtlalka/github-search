package net.tlalka.github.search.feature.projectlist.view.binding

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.card.MaterialCardView
import net.tlalka.github.search.R
import net.tlalka.github.search.feature.projectlist.view.listener.SearchChangeListener

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

    @BindingAdapter("custom_projectSearchChangeListener")
    @JvmStatic
    fun EditText.onTextChangeListener(listener: SearchChangeListener) {
        addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(text: Editable) = listener.onSearchChange(text.toString())

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
        })
    }
}