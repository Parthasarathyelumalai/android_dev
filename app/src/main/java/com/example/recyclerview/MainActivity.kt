package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var showBtn: Button
    private lateinit var cbFilter: CheckBox
    private val mutableList: ArrayList<Details> = ArrayList<Details>()
    private lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btRegistered)
        cbFilter = findViewById(
            R.id.cbFilter
        )
        var intent: Intent
        btn.setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            getResult.launch(intent)
        }
        showBtn = findViewById(
            R.id.btShowResult
        )
        val recycler: RecyclerView = findViewById(R.id.rvView)

        showBtn.setOnClickListener {
            if (cbFilter.isChecked) {
                val employeeDetailsList = EmployeeDetailsList(this, mutableList.filter { it.isFavorite } as ArrayList<Details>)
                employeeDetailsList.notifyDataSetChanged()
                recycler.adapter = employeeDetailsList
                recycler.layoutManager = LinearLayoutManager(this)
            }
            else {
                val employeeDetailsList = EmployeeDetailsList(this, mutableList)
                employeeDetailsList.notifyDataSetChanged()
                recycler.adapter = employeeDetailsList
                recycler.layoutManager = LinearLayoutManager(this)
            }
        }
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            val bundle = it.data?.getBundleExtra("list")
            bundle?.apply {
                data =
                    "name : ${bundle.getString("name")} \nEmail Id : ${bundle.getString("emailId")} \nPhone number: ${
                        bundle.getString("phoneNumber")
                    }"
                println(data)
                mutableList.add(Details(data))

            }
            val recycler: RecyclerView = findViewById(R.id.rvView)
                val employeeDetailsList = EmployeeDetailsList(this, mutableList)
                recycler.adapter = employeeDetailsList
                recycler.layoutManager = LinearLayoutManager(this)
        }
}