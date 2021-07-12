package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserDetailsView

class UserDetailsPresenter(private val router: Router) : MvpPresenter<UserDetailsView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.renderDetails()
    }

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}