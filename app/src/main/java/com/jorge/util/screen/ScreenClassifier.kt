package com.jorge.util.screen

import android.graphics.Rect
import androidx.window.layout.FoldingFeature

sealed interface ScreenClassifier {

    data class FullyOpened(
        val height: Dimension,
        val width: Dimension
    ) : ScreenClassifier

    sealed interface HalfOpened : ScreenClassifier {
        val hingPosition: Rect
        val hingeSeparationRatio: Float
        val isSeparating: Boolean
        val occlusionTye: FoldingFeature.OcclusionType

        data class BookMode(
            override val hingPosition: Rect,
            override val hingeSeparationRatio: Float,
            override val isSeparating: Boolean,
            override val occlusionTye: FoldingFeature.OcclusionType
        ): HalfOpened

        data class TableTopMode(
            override val hingPosition: Rect,
            override val hingeSeparationRatio: Float,
            override val isSeparating: Boolean,
            override val occlusionTye: FoldingFeature.OcclusionType
        ): HalfOpened
    }
}