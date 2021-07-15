package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser

class GithubUserRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5"),
        GithubUser("login6"),
        GithubUser("login7"),
        GithubUser("login8"),
        GithubUser("login9"),
        GithubUser("login10"),
    )

    fun getUsers(): Observable<List<GithubUser>>{
        return Observable.just(users)
    }

    fun getLoginByIndex(i: Int): String{
        return users[i].login
    }
}