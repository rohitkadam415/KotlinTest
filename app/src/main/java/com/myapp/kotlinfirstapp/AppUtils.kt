package com.myapp.kotlinfirstapp

import android.widget.EditText

object AppUtils {
    fun getrandomNumber(): Double {
        var id = Math.random();
        return id
    }

    fun isEmpty(editText: EditText, msg: String): Boolean {
        if (editText.text.isEmpty()) {
            editText.setError(msg)
            return false;
        }
        return true;
    }

    fun getData(): ArrayList<DataModel>? {
        var nm: String? = null;
        val datalist: ArrayList<DataModel>? = ArrayList();

        for (k in 1 until 20) {
            datalist?.add(DataModel("String" + k,k))
        }
        return datalist
    }
}