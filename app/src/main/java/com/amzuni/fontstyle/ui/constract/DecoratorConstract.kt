package com.amzuni.fontstyle.ui.constract

import com.amzuni.fontstyle.model.Style

interface DecoratorConstract {
    interface IView{
        fun updateStyleListUI(styleList: MutableList<Style>)
        fun notifyDataChange()
    }
    interface IPresenter {
        fun setView(view: IView)
        fun getStyleList()
        fun setTextDecorator(text: String)
    }
}