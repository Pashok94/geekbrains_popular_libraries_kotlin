package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list

interface UserItemView: IItemView {
    fun setLogin(login: String)
    fun initClickListener()
}