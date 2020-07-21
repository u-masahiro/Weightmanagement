package com.example.weightmanagement.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weightmanagement.R
import com.example.weightmanagement.viewmodel.InputViewModel
import kotlinx.android.synthetic.main.fragment_pager_base.*

class PagerBaseFragment :Fragment(){

    private lateinit var adapter: ExistListAdapter
    private val viewModel: InputViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pager_base, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerViewの取得
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        // LayoutManagerの設定
        recycler_view.layoutManager = LinearLayoutManager(context)

        // ExistListAdapterの生成と設定
        viewModel.weights.observe(viewLifecycleOwner, Observer {
            adapter = ExistListAdapter(it)
            recyclerView.adapter = adapter
        })

        fab_base.setOnClickListener {
            findNavController().navigate(R.id.inputFragment)
        }
    }
}
