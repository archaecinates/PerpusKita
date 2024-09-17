package com.example.perpuskita.data

import android.content.Intent
import com.example.perpuskita.R
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.perpuskita.Buku
import com.excal.simplerecyclerview.Data.TransactionViewModel
import com.excal.simplerecyclerview.Data.TransactionViewModelFactory
import com.excal.simplerecyclerview.databinding.ActivityInputBukuBinding
import java.text.SimpleDateFormat
import java.util.Date

class InputBuku : AppCompatActivity() {

    private lateinit var  binding: ActivityInputBukuBinding
    private val transactionViewModel: TransactionViewModel by viewModels{
        TransactionViewModelFactory(AppDatabase.getInstance(applicationContext).transactionDao())
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivityInputBukuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnBack.setOnClickListener{
            val intent = Intent(this, Buku::class.java)
            startActivity(intent)
        }

        binding.btnAdd.setOnClickListener{
            var target=binding.etTarget.text.toString()
            var amount=binding.etAmount.text.toString().toInt()
            var date= SimpleDateFormat("dd/MM/YYYY").format(Date())
            var imageId:Int=binding.etImgId.text.toString().toInt()

            if(target.isEmpty()||amount==null||date.isEmpty()||imageId==null){
                Toast.makeText(this, "Please fill in all the information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            transactionViewModel.insertTransaction(Transaction(targetName=target, amount=amount,
                date=date, idGambar=imageId))

        }

        transactionViewModel.insertSuccess.observe(this, Observer{success->
            if(success){
                val intent=Intent(this, Buku::class.java)
                startActivity(intent)
                finish()
            }
        })

    }
}