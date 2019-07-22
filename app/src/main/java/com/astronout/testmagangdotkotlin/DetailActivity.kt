package com.astronout.testmagangdotkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private val EXTRA_CAPTION: String = "CAPTION"
    private val EXTRA_IMAGE: String = "IMAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image: String = intent.getStringExtra(EXTRA_IMAGE)
        val caption: String = intent.getStringExtra(EXTRA_CAPTION)

        detail_caption.text = caption
        Glide.with(this)
            .load(image)
            .into(detail_img)

    }
}
