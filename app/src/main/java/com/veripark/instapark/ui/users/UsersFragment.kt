package com.veripark.instapark.ui.users

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.veripark.instapark.R
import com.veripark.instapark.data.model.Users
import com.veripark.instapark.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_users.*


@AndroidEntryPoint
class UsersFragment : Fragment() {

    private val usersViewModel : UsersViewModel by viewModels()
    private  lateinit var usersAdapter : UsersAdapter
    private lateinit var mcontext :Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            mcontext = this.context!!

            setupUI()
            setupObserver()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UsersFragment().apply {
                arguments = Bundle().apply {


                }
            }
    }
    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(mcontext)
        usersAdapter = UsersAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = usersAdapter
    }

    private fun setupObserver() {
        usersViewModel.users.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                   // progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                    Log.d("VERi",it.data.toString())
                }
                Status.LOADING -> {
                    Log.d("VERi",it.data.toString())

                    //progressBar.visibility = View.VISIBLE
                    //recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    Log.d("HATA",it.data.toString())

                    //Handle Error
                   // progressBar.visibility = View.GONE
                    Toast.makeText(mcontext, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<Users>) {
        usersAdapter.addData(users)
        usersAdapter.notifyDataSetChanged()
    }
}