package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentUserDetailsBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UserDetailsPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserDetailsView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackButtonListener

class UserDetailsFragment: MvpAppCompatFragment(), UserDetailsView, BackButtonListener {
    companion object{
        const val LOGIN_EXTRA = "loginExtra"
        fun getInstance(login: String) : Fragment {
            val fragment = UserDetailsFragment()
            val bundle = Bundle()
            bundle.putString(LOGIN_EXTRA, login)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var vb: FragmentUserDetailsBinding? = null
    private val presenter by  moxyPresenter {
        UserDetailsPresenter(App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun renderDetails() {
        vb?.tvLogin?.text = arguments?.getString(LOGIN_EXTRA)
    }

    override fun backPressed(): Boolean {
        return presenter.backClick()
    }
}