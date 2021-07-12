package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UserDetailsFragment
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UserFragment

class AndroidScreen: IScreens {
    override fun users(): Screen {
        return FragmentScreen{
            UserFragment.getInstance()
        }
    }

    override fun userDetails(login: String): Screen {
        return FragmentScreen{
            UserDetailsFragment.getInstance(login)
        }
    }
}