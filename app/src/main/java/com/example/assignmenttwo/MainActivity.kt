package com.example.assignmenttwo

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.Toast
import com.example.assignmenttwo.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private val calendar= Calendar.getInstance()
    var dob:String?=null
    var rollno:String?=null
    var name:String?=null
    var password:String?=null
    var className:String?=null
    var gender:String?=null
    var ph:String?=null
    var add:String?=null
    private val formatter= SimpleDateFormat("MMMM d,yyyy", Locale.US)
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val languages = resources.getStringArray(R.array.Languages)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, languages
        )
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
//                Toast.makeText(
//                    this@MainActivity,
//                    "Selected item " + " " + "" + languages[position],
//                    Toast.LENGTH_SHORT
//                ).show()
                className=languages[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

//        if(binding.femaleRd.isChecked)
//            gender=binding.femaleRd.text.toString()
//        else if(binding.maleRd.isChecked)
//            gender=binding.maleRd.text.toString()
        binding.saveBtn.setOnClickListener {
            rollno=binding.rollNo.text.toString()
            name=binding.name.text.toString()
            password=binding.password.text.toString()
            ph=binding.phone.text.toString()
            add=binding.address.text.toString()
            val selectedRadioButtonId: Int = binding.gender.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
           val gender: String = selectedRadioButton.text.toString()
          // val stu:Student=Student(rollno!!, name!!, password!!,className!!,gender!!,dob!!,ph!!,add!!)
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("roll",rollno)
            intent.putExtra("name",name)
            intent.putExtra("ph",ph)
            intent.putExtra("add",add)
            intent.putExtra("dob",dob)
            intent.putExtra("gen",gender)
            intent.putExtra("cName",className)
            startActivity(intent)
        }
        binding.imageButton.setOnClickListener {
            DatePickerDialog(this,this,calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year,month,dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
        //TimePickerDialog(this,this,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show()
    }
    private fun displayFormattedDate(timestamp: Long){
       // binding.textView.text=formatter.format(timestamp)
        dob=formatter.format((timestamp))
       // Log.i("Formatting",timestamp.toString())
    }

}