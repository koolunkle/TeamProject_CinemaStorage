package kr.or.mrhi.cinemastorage.view.decoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class Decoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val count = state.itemCount
        val offset = 30

        when (position) {
            0 -> {
                outRect.top = offset
            }
            count - 1 -> {
                outRect.bottom = offset
            }
            else -> {
                outRect.top = offset
                outRect.bottom = offset
            }
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val widthMargin = 20f
        val height = 2f
        val paint = Paint()
        val left = parent.paddingStart.toFloat()
        val right = (parent.width - parent.paddingEnd).toFloat()
        paint.color = Color.parseColor("#727272")

        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val layoutParams = view.layoutParams as RecyclerView.LayoutParams
            val top = view.bottom.toFloat() + layoutParams.bottomMargin
            val bottom = top + height
            c.drawRect(left + widthMargin, top, right - widthMargin, bottom, paint)
        }
    }

}