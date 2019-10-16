package net.tlalka.github.search.feature.projectlist.view.binding

import android.view.KeyEvent
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
    @BindingAdapter("custom_projectMemorySize")
    fun TextView.projectSizeInKb(sizeInKb: Int) {
        text = if (sizeInKb > 1000) {
            resources.getString(R.string.project_list_item_size_in_mb, sizeInKb / 1000)
        } else {
            resources.getString(R.string.project_list_item_size_in_kb, sizeInKb)
        }
    }

    @BindingAdapter("custom_projectSearchChangeListener")
    @JvmStatic
    fun EditText.onEnterListener(listener: SearchChangeListener) {
        setOnKeyListener(object : View.OnKeyListener {

            override fun onKey(view: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (isEnterPressed(event)) {
                    listener.onSearchEneter(text.toString())
                    return true
                }
                return false
            }

            private fun isEnterPressed(event: KeyEvent): Boolean =
                (event.action == KeyEvent.ACTION_DOWN) && (event.keyCode == KeyEvent.KEYCODE_ENTER)
        })
    }
}