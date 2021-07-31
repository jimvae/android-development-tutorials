//package com.orbital.firestore
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import com.google.android.gms.tasks.OnSuccessListener
//import com.google.firebase.FirebaseApp
//import com.google.firebase.firestore.CollectionReference
//import com.google.firebase.firestore.DocumentReference
//import com.google.firebase.firestore.FirebaseFirestore
//import java.util.*
//
//class MainActivity : AppCompatActivity() {
//
//    var keyTitle: String = "title"
//    var keyDescription: String = "description"
//
//    private lateinit var editTextTitle: EditText
//    private lateinit var editTextDescription: EditText
//    private lateinit var textViewData: TextView
//
//    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
//    private var noteRef: DocumentReference = db.collection("Notebook").document("My First Note")
//    //or db.document("Notebook/My First Note")
//
//    private var docRef: CollectionReference = db.collection("Notebook")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        editTextTitle = findViewById(R.id.edit_title)
//        editTextDescription = findViewById(R.id.edit_description)
//        textViewData = findViewById(R.id.text_data)
//
//    }
//
//    fun saveNote(v: View) {
//        val title: String = editTextTitle.text.toString()
//        val description = editTextDescription.text.toString()
//
//        val note = HashMap<String, Any>()
//        note[keyTitle] = title
//        note[keyDescription] = description
//
//        //db.document("Notebook/My First Note") or
//        noteRef.set(note)
//            .addOnSuccessListener {
//                Toast.makeText(applicationContext, "Note saved", Toast.LENGTH_SHORT).show()
//                }.addOnFailureListener {
//                    Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
//                    Log.d("Main Activity", it.toString())
//                }
//    }
//
//    fun loadNote(v: View) {
//        noteRef.get()
//            .addOnSuccessListener {
//                if (it.exists()) {
//                    var title = it.getString(keyTitle)
//                    var description = it.getString(keyDescription)
//                    textViewData.setText("Title: ${title}" + "\n" + "${description}")
//                } else Toast.makeText(applicationContext, "Document does not exist", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener {
//                Toast.makeText(applicationContext, "Error!", Toast.LENGTH_SHORT).show()
//                Log.d("Main Activity", it.toString())
//            }
//
//    }
//
//
//}

package com.orbital.firestore

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.orbital.firestore.R
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var btnDatePicker: Button
    lateinit var btnTimePicker: Button
    lateinit var txtDate: EditText
    lateinit var txtTime: EditText
    private var mYear = 0
    private var mMonth = 0
    private var mDay = 0
    private var mHour = 0
    private var mMinute = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker = findViewById(R.id.btn_date)
        btnTimePicker = findViewById(R.id.btn_time)
        txtDate = findViewById(R.id.in_date)
        txtTime = findViewById(R.id.in_time)
        txtDate.setOnClickListener {
            // Get Current Date
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(
                this,
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    txtDate!!.setText(
                        dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                    )
                }, mYear, mMonth, mDay
            )
            datePickerDialog.show()
        }

        txtTime.setOnClickListener {


                // Get Current Time
                val c = Calendar.getInstance()
                mHour = c[Calendar.HOUR_OF_DAY]
                mMinute = c[Calendar.MINUTE]

                // Launch Time Picker Dialog
                val timePickerDialog = TimePickerDialog(
                    this,
                    OnTimeSetListener { view, hourOfDay, minute -> txtTime!!.setText("$hourOfDay:$minute") },
                    mHour,
                    mMinute,
                    false
                )
                timePickerDialog.show()

        }
    }
}

