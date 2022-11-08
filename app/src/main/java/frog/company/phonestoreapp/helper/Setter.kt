package frog.company.phonestoreapp.helper

import android.graphics.Paint
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import frog.company.phonestoreapp.adapter.AdapterImage
import frog.company.phonestoreapp.model.Details

class Setter {

    companion object {
        @JvmStatic
        @BindingAdapter(value = ["imageUrl"])
        fun loadImage(
            view: AppCompatImageView,
            imageUrl: String?
        ) {
            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).into(view)
            }
        }

        @JvmStatic
        @BindingAdapter(value = ["imageDrawable"])
        fun loadImageDrawable(
            view: FloatingActionButton,
            imageDrawable: Int
        ) {
            view.setImageResource(imageDrawable)
        }


        @JvmStatic
        @BindingAdapter(value = ["paintFlags"])
        fun loadImage(
            view: TextView,
            paintFlags: Boolean
        ) {
            view.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG;
        }
    }
}