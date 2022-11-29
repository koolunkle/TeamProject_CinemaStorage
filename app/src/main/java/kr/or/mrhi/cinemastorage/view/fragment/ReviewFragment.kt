package kr.or.mrhi.cinemastorage.view.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.or.mrhi.cinemastorage.R
import kr.or.mrhi.cinemastorage.databinding.ActivityBoardWriteBinding

class ReviewFragment : AppCompatActivity() {

    private lateinit var binding: ActivityBoardWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener {
        }

        val title = binding.titleArea.text.toString()
        val content = binding.contentArea.text.toString()
       }
    }