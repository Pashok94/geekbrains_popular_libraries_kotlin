package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.GithubUserRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list.IUserListPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UsersView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.UserItemView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.navigation.AndroidScreen


class UsersPresenter(val userRepo: GithubUserRepo, val router: Router) : MvpPresenter<UsersView>() {

    inner class UserListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = {
            router.replaceScreen(AndroidScreen().userDetails(userRepo.getLoginByIndex(it.pos)))
        }

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
            view.initClickListener()
        }

        override fun getCount() = users.size
    }

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {
        val users = userRepo.getUsers()
        userListPresenter.users.clear()
        userListPresenter.users.addAll(users)
    }

    fun backClick(): Boolean{
        router.exit()
        return true
    }
}