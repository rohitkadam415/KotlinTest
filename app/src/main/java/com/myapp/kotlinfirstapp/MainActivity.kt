package com.myapp.kotlinfirstapp

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

// class is extends with ':' and separated interface with ','
class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Implemeted onclick listeners here
    override fun onClick(v: View?) {
        // 'switch' is replace with 'when' in kotlin
        // '?' is check view is not null
        when (v?.id) {
            // this is button id declared in xml file
            R.id.btn_open_popup -> {
                showCreateCategoryDialog()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Button Id 'btn_open_popup' directly used from xml file. its not want define by using findviewbyid
        btn_open_popup.setOnClickListener(this)
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),777)
        }
    }

    // this reset button click which calling from xml
    fun resetClicked(view: View) {
        // Edittext Id directly used from xml file. its not want define by using findviewbyid
        et_user_name.setText("")
        et_password?.setText("")
        et_user_name?.requestFocus();
    }

    // this submit button click which calling from xml
    fun btnSubmitClicked(view: View) {
        // isEmpty() is accessed from AppUtils kotlin file
        if (AppUtils.isEmpty(et_user_name, getString(R.string.err_fields_are_empty)) && AppUtils.isEmpty(
                et_password,
                getString(R.string.err_fields_are_empty)
            )
        ) {
            //launchnewActivity is accessed from ActivityNavigator class which is used to launch new activty
            ActivityNavigator.launchnewActivity(this, et_user_name.text.toString(), et_password.text.toString())
        }
    }


    fun showCreateCategoryDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Category")
        val view = layoutInflater.inflate(R.layout.dialog, null)
        val categoryEditText = view.findViewById<EditText>(R.id.categoryEditText)
        builder.setView(view);

        builder.setPositiveButton(android.R.string.ok)
        { dialog: DialogInterface, i: Int ->
            if (AppUtils.isEmpty(categoryEditText, getString(R.string.err_fields_are_empty))) {
                var newCategory = categoryEditText.text
                Toast.makeText(view.context, newCategory, Toast.LENGTH_LONG).show()
                dialog.cancel()
            }
        }
        builder.setNegativeButton(android.R.string.cancel)
        { dialog: DialogInterface, i: Int ->
            dialog.cancel()
        }
        builder.show();
    }

    // permission results i.e allow or denied
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            777-> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }

}
