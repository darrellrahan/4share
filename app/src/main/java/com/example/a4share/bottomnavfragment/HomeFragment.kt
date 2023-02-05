package com.example.a4share.bottomnavfragment

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.a4share.CarouselHomeAdapter
import com.example.a4share.R
import me.relex.circleindicator.CircleIndicator3

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = view.findViewById<ViewPager2>(R.id.view_pager)
        val filter: Spinner = view.findViewById<Spinner>(R.id.filter_spinner)

        viewPager.post {
            viewPager.setCurrentItem(1, true)
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

        viewPager.adapter = CarouselHomeAdapter(
            arrayListOf("Apa itu Cyber Security Mesh?", "Perbedaan setInterval dan setTimeOut di Javascript?", "Tutorial nyebrang jembatan shiratal mustaqim?"),
            arrayListOf("Alifah", "Darrell", "Azril"),
            arrayListOf("Dijawab, 23 Jan 2023", "Dijawab, 5 Feb 2023", "Dijawab, 1 Feb 2023"),
            arrayListOf("Cyber Security Mesh adalah Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore  ...", "Jadi gini kak, perbedaan antara setTimeOut dan setInterval di JavaScript adalah ... Gacukup lanjut part 2", "Ga relate Kristen 🙏"),
            arrayListOf(9, 6, 420)
        )

        val filters = arrayOf("Pertanyaan Terbaru", "Pertanyaan Populer")
        val filterAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, filters)

        filter.adapter = filterAdapter

        val indicator = view.findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_bottomnav, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}