package ru.ivan.englishdictionary

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import moxy.MvpAppCompatActivity
import ru.ivan.englishdictionary.detail.view.DetailFragment
import ru.ivan.englishdictionary.detail.view.NavigateListener
import ru.ivan.englishdictionary.search.view.SearchFragment

class HomeActivity : MvpAppCompatActivity(), NavigateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    override fun navigateTo(detailFragment: DetailFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, detailFragment, null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null)
            .commit()
    }

    private fun initUI() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, SearchFragment(), null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}
