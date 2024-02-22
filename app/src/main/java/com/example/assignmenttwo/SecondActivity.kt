package com.example.assignmenttwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmenttwo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val stu: Student? = getIntent().getExtras()?.getParcelable("stu");
        //val stu: Student? = intent.getParcelableExtra<Student>("stu")
        val extras = intent.extras
        binding.rollView.text="${binding.rollView.text} ${extras?.getString("roll")}"
        binding.nameView.text ="${binding.nameView.text} ${extras?.getString("name")}"
        binding.addressView.text="${binding.addressView.text} ${extras?.getString("add")}"
        binding.dobView.text="${binding.dobView.text} ${extras?.getString("dob")}"
        binding.classView.text="${binding.classView.text} ${extras?.getString("cName")}"
        binding.genderView.text="${binding.genderView.text} ${extras?.getString("gen")}"
        binding.phView.text="${binding.phView.text} ${extras?.getString("ph")}"

    }
}