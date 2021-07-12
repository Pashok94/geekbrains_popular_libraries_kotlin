package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.ActivityMainBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.MainPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.MainView

class MainActivity : AppCompatActivity(), MainView {

    private var vb: ActivityMainBinding? = null
    val presenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        initCountBtn()
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> vb?.btnCounter1?.text = text
            1 -> vb?.btnCounter2?.text = text
            2 -> vb?.btnCounter3?.text = text
        }
    }

    private fun initCountBtn(){
        val counter1IsClicked = View.OnClickListener {
            presenter.counter1Click()
        }
        val counter2IsClicked = View.OnClickListener {
            presenter.counter2Click()
        }
        val counter3IsClicked = View.OnClickListener {
            presenter.counter3Click()
        }

        vb?.btnCounter1?.setOnClickListener(counter1IsClicked)
        vb?.btnCounter2?.setOnClickListener(counter2IsClicked)
        vb?.btnCounter3?.setOnClickListener(counter3IsClicked)
    }
}