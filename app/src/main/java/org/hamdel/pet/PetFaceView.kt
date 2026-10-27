package org.hamdel.pet

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * A small, original, native-drawn pet illustration. It intentionally does not reuse Pou artwork.
 */
class PetFaceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val body = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFFFC857.toInt() }
    private val shade = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFF2A93B.toInt() }
    private val white = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFFFFFFF.toInt() }
    private val dark = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFF3E3430.toInt() }
    private val blush = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = 0xFFFF8A80.toInt() }
    private val mouth = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = 0xFF6D3434.toInt()
        style = Paint.Style.STROKE
        strokeWidth = 5f
        strokeCap = Paint.Cap.ROUND
    }

    init {
        contentDescription = "تصویر یک حیوانک گرد و زرد با چشم‌های درشت و لبخند"
        importantForAccessibility = IMPORTANT_FOR_ACCESSIBILITY_YES
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desired = (220 * resources.displayMetrics.density).toInt()
        val width = resolveSize(desired, widthMeasureSpec)
        val height = resolveSize(desired, heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val side = minOf(width, height).toFloat()
        val cx = width / 2f
        val cy = height / 2f
        val scale = side / 240f
        canvas.save()
        canvas.translate(cx - 120f * scale, cy - 120f * scale)
        canvas.scale(scale, scale)

        // Soft shadow and rounded body.
        paint.color = 0x22000000
        canvas.drawOval(RectF(34f, 198f, 206f, 226f), paint)
        canvas.drawRoundRect(RectF(28f, 18f, 212f, 212f), 72f, 72f, shade)
        canvas.drawRoundRect(RectF(28f, 12f, 212f, 202f), 72f, 72f, body)

        // Eyes.
        canvas.drawOval(RectF(66f, 74f, 105f, 123f), white)
        canvas.drawOval(RectF(135f, 74f, 174f, 123f), white)
        canvas.drawCircle(88f, 100f, 13f, dark)
        canvas.drawCircle(153f, 100f, 13f, dark)
        paint.color = 0xFFFFFFFF.toInt()
        canvas.drawCircle(92f, 95f, 4f, paint)
        canvas.drawCircle(157f, 95f, 4f, paint)

        // Cheeks and smile.
        canvas.drawOval(RectF(47f, 125f, 78f, 143f), blush)
        canvas.drawOval(RectF(162f, 125f, 193f, 143f), blush)
        canvas.drawArc(RectF(85f, 112f, 155f, 166f), 15f, 150f, false, mouth)

        // Tiny sparkle.
        paint.color = 0xFFFFFFFF.toInt()
        canvas.drawCircle(52f, 47f, 5f, paint)
        canvas.drawCircle(190f, 45f, 4f, paint)
        canvas.restore()
    }
}
