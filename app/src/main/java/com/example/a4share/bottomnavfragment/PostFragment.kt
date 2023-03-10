package com.example.a4share.bottomnavfragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.PermissionChecker
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.a4share.Chat
import com.example.a4share.Dashboard
import com.example.a4share.PanduanSidebar
import com.example.a4share.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_post_bottomnav.*
import kotlinx.android.synthetic.main.header.*
import kotlinx.android.synthetic.main.post_layout.*
import java.util.jar.Manifest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_post_bottomnav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category: Spinner = view.findViewById(R.id.category)
        val uploadPicture: ImageView = view.findViewById(R.id.upload_camera)
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

        val categories = arrayOf("PPLG", "TJKT", "DKV", "TOI", "TlITL", "AV")

        val categoryAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, categories)
        category.adapter = categoryAdapter

        uploadPicture.isEnabled = true

        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CAMERA), 100)
        } else {
            uploadPicture.isEnabled = true
        }

        uploadPicture.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 101)
        }

        upload_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 101) {
            val pic: Bitmap? = data?.getParcelableExtra<Bitmap>("data")
            preview.setImageBitmap(pic?.let { Bitmap.createScaledBitmap(it, 225, 200, false) })

            remove_preview.visibility = View.VISIBLE
            remove_preview.setOnClickListener {
                preview.setImageBitmap(null)
                remove_preview.visibility = View.GONE
            }
        }

        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            val pic: Bitmap? = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, data?.data)
            preview.setImageBitmap(pic?.let { Bitmap.createScaledBitmap(it, 225, 200, false) })

            remove_preview.visibility = View.VISIBLE
            remove_preview.setOnClickListener {
                preview.setImageBitmap(null)
                remove_preview.visibility = View.GONE
            }
        }
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
         * @return A new instance of fragment PostFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic

        val IMAGE_REQUEST_CODE = 100

        fun newInstance(param1: String, param2: String) =
            PostFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}