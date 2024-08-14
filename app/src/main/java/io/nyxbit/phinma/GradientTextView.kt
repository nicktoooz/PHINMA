package io.nyxbit.phinma

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class GradientTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        val colors = intArrayOf(
            Color.parseColor("#232C64"),
            Color.parseColor("#337837")
        )

        val textShader = LinearGradient(
            0f, 0f, width.toFloat(), height.toFloat(),
            colors, null, Shader.TileMode.CLAMP
        )

        paint.shader = textShader

        super.onDraw(canvas)
    }
}
