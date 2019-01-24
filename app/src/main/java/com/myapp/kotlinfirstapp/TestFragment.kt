package com.myapp.kotlinfirstapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

//fragment is implements TestInteface interface which is implements clicked() method
class TestFragment : Fragment(), TestInterface {

    var datalist: ArrayList<DataModel>? = null


    // override method is defined in Testinterface
    override fun clicked(position: Int) {
        Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_test, container, false)
        datalist = ArrayList();
        datalist = AppUtils.getData()

        var recycleView = view.findViewById<RecyclerView>(R.id.rv_list);

        recycleView.layoutManager = LinearLayoutManager(context)

        var adapter = recycleAdapter(datalist!!, context, this);

        recycleView.adapter = adapter;

        return view;
    }


}
