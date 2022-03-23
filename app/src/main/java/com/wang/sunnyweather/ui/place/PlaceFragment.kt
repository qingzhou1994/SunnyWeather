package com.wang.sunnyweather.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.wang.sunnyweather.databinding.FragmentPlaceBinding

class PlaceFragment : Fragment() {
    private lateinit var bindView: FragmentPlaceBinding

    val viewModel by lazy { ViewModelProvider(this)[PlaceViewModel::class.java] }

    private lateinit var placeAdapter: PlaceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindView = FragmentPlaceBinding.inflate(inflater, container, false)
        return bindView.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        placeAdapter = PlaceAdapter(viewModel.placeList)
        bindView.rvPlace.layoutManager = LinearLayoutManager(activity)
        bindView.rvPlace.adapter = placeAdapter
        bindView.etSearch.addTextChangedListener {
            val content = it.toString()
            if (content.isNotEmpty()) {
                viewModel.searchPlaces(content)
            } else {
                bindView.rvPlace.visibility = View.GONE
                bindView.ivBg.visibility = View.VISIBLE
                viewModel.placeList.clear()
                placeAdapter.notifyDataSetChanged()
            }
        }
        viewModel.placeLiveData.observe(viewLifecycleOwner, Observer {
            val places = it.getOrNull()
            if (places != null) {
                bindView.ivBg.visibility = View.GONE
                bindView.rvPlace.visibility = View.VISIBLE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(places)
                placeAdapter.notifyDataSetChanged()
            }else{
                it.exceptionOrNull()?.printStackTrace()
            }
        })
    }
}