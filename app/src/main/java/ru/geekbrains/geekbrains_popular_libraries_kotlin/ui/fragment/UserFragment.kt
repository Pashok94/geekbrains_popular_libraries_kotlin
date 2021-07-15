package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentUsersBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.GithubUserRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UsersPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UsersView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackButtonListener
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.adapter.UsersRVAdapter

class UserFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object{
        fun getInstance() : Fragment{
            return UserFragment()
        }
    }

    private var vb: FragmentUsersBinding? = null
    private var adapter: UsersRVAdapter? = null

    val presenter by moxyPresenter {
        UsersPresenter(GithubUserRepo(), App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentUsersBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        vb = null
    }

    override fun init() {
        adapter = UsersRVAdapter(presenter.userListPresenter)
        vb?.rvUsers?.layoutManager = LinearLayoutManager(requireContext())
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        return presenter.backClick()
    }
}