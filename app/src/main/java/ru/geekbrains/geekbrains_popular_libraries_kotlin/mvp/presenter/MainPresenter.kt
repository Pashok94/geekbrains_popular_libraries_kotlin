package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.CountersModel
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView


class MainPresenter(val view: MainView) {

    val model = CountersModel()

    fun counter1Click(){
        val nextValue = model.next(0)
        view.setButtonText(0, nextValue.toString())
    }

    fun counter2Click(){
        val nextValue = model.next(1)
        view.setButtonText(1, nextValue.toString())
    }

    fun counter3Click(){
        val nextValue = model.next(2)
        view.setButtonText(2, nextValue.toString())
    }
}