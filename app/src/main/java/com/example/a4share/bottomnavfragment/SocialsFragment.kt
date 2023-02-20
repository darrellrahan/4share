package com.example.a4share.bottomnavfragment

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.a4share.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_socials_bottomnav.*
import kotlinx.android.synthetic.main.header.*
import kotlinx.android.synthetic.main.social_layout.*
import me.relex.circleindicator.CircleIndicator3

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var toggleSidebar: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_socials_bottomnav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = view.findViewById<ViewPager2>(R.id.view_pager_socials)
        val drawerLayout: DrawerLayout = view.findViewById(R.id.drawer_layout)
        val sidebar: NavigationView = view.findViewById(R.id.sidebar_view)
        val sidebarHeader: View = sidebar.getHeaderView(0)

        toggleSidebar = ActionBarDrawerToggle(requireActivity(), drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggleSidebar)
        toggleSidebar.syncState()

        open_sidebar.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        open_chat.setOnClickListener {
            startActivity(Intent(requireContext(), Chat::class.java))
        }

        sidebar.setNavigationItemSelectedListener {
            if(it.itemId == R.id.ic_panduan) {
                startActivity(Intent(activity, PanduanSidebar::class.java))
                activity?.finish()
            }

            if(it.itemId == R.id.ic_home) {
                startActivity(Intent(activity, Dashboard::class.java))
                activity?.finish()
            }

            true
        }

        viewPager.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        }

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer((40 * Resources.getSystem().displayMetrics.density).toInt()))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        viewPager.setPageTransformer(compositePageTransformer)

        viewPager.adapter = CarouselSocialsAdapter(
            arrayListOf("Rizky Billiard", "Lesley", "Baby El"),
            arrayListOf("562 Pengikut", "69 Pengikut", "420 Pengikut"),
            arrayListOf("TJKT", "TITL", "PPLG"),
            arrayListOf("111 Jawaban", "123 Jawaban", "124 Jawaban"),
            arrayListOf("25 Pertanyaan", "24 Pertanyaan", "23 Pertanyaan")
        )

        val indicator = view.findViewById<CircleIndicator3>(R.id.indicator_socials)
        indicator.setViewPager(viewPager)

        val filters = arrayOf("Following", "Followers")
        val filterAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, filters)
        filter_social.adapter = filterAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggleSidebar.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}