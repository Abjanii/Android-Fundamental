package com.kimdevsubmission

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kimdevsubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            rvGithub.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGithub.adapter = PeopleAdapter(terimaDataArray())
        }
    }
    @SuppressLint("Recycle" )
    private fun terimaDataArray(): ArrayList<People> {
        val terimaFoto = resources.obtainTypedArray(R.array.avatar)
        val terimaNama = resources.getStringArray(R.array.name)
        val terimaUsername = resources.getStringArray(R.array.username)
        val terimaPengikut = resources.getStringArray(R.array.followers)
        val terimaMengikuti = resources.getStringArray(R.array.following)
        val terimaRepo = resources.getStringArray(R.array.repository)
        val terimaPerusahaan = resources.getStringArray(R.array.company)
        val terimaLokasi = resources.getStringArray(R.array.location)

        val kumpulanData: ArrayList<People> = arrayListOf()
        for (posisi in terimaNama.indices) {
            val dataPeople = People(
                terimaFoto.getResourceId(posisi, -1),
                terimaNama[posisi],
                terimaUsername[posisi],
                terimaPengikut[posisi],
                terimaMengikuti[posisi],
                terimaRepo[posisi],
                terimaPerusahaan[posisi],
                terimaLokasi[posisi]
            )
            kumpulanData.add(dataPeople)
        }
        return kumpulanData
    }
}