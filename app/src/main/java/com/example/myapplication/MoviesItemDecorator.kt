package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MoviesItemDecorator(
    context: Context,
    private val sidePadding: Int,
    private val topAndBottomPadding: Int
): RecyclerView.ItemDecoration( ) {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        //outRect.left = view.width / 8

        //outRect.right = sidePadding
        //outRect.top = topAndBottomPadding
        //outRect.bottom = topAndBottomPadding
    }

}