package com.deviange.androidinjection.sample

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.deviange.androidinjection.AndroidInjectionExt
import javax.inject.Inject

class AndroidInjectedTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    @Inject
    lateinit var someString: String

    init {
        AndroidInjectionExt.inject(this)
        setText(someString)
    }
}