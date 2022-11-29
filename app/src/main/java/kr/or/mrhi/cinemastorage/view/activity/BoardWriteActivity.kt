package kr.or.mrhi.cinemastorage.view.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bokchi.mysolelife.utils.FBAuth
import kr.or.mrhi.cinemastorage.R
import kr.or.mrhi.cinemastorage.data.Review
import kr.or.mrhi.cinemastorage.databinding.ActivityBoardWriteBinding
import kr.or.mrhi.cinemastorage.databinding.FragmentReviewBinding
import kr.or.mrhi.cinemastorage.utils.FBRef

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener{

            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            Log.d(TAG, title)
            Log.d(TAG, content)

            FBRef.boardRef
                .push()
                .setValue(Review(title, content, uid, time))

            Toast.makeText(this, "리뷰 등록이 완료되었습니다.", Toast.LENGTH_LONG).show()

            finish()
        }
    }
}
