package jp.ac.it_college.s20022.quiz


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.it_college.s20022.quiz.databinding.ActivityQuizMainBinding

class QuizMain : AppCompatActivity() {
    private lateinit var binding: ActivityQuizMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aButton.setOnClickListener {
            val intent = Intent(this, QuizActivityResults::class.java)
            startActivity(intent)
        }
    }

}