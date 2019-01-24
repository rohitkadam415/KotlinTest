package com.myapp.kotlinfirstapp

import android.content.Context
import android.content.Intent

object ActivityNavigator {

    fun launchnewActivity(context: Context, userName: String, pass: String) {
        val intent = Intent(context, SecondActivity::class.java)
        intent.putExtra(context.getString(R.string.user), userName)
        intent.putExtra(context.getString(R.string.pass), pass)
        context.startActivity(intent)
    }
}