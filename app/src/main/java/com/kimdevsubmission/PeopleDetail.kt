package com.kimdevsubmission

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kimdevsubmission.databinding.DetailPeopleBinding

class PeopleDetail : AppCompatActivity() {
    private lateinit var bind: DetailPeopleBinding

    companion object {
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DetailPeopleBinding.inflate(layoutInflater)
        setContentView(bind.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        terimaData()

    }

    @SuppressLint("SetTextI18n")
    private fun terimaData() {
        val paket = intent.getParcelableExtra<People>(EXTRA_DATA) as People
        bind.fotoDetail.setImageResource(paket.avatar)
        bind.namaDetail.text = paket.name
        bind.usernameDetail.text = paket.username
        bind.followerDetail.text = """
            Followers : ${paket.follower}
        """.trimIndent()
        bind.followingDetail.text = """
            Following : ${paket.following}
        """.trimIndent()
        bind.repoDetail.text = """
            Repository : ${paket.repo}
        """.trimIndent()
        bind.companyDetail.text = paket.company
        bind.locationDetail.text = paket.location
        title = paket.name
    }
}