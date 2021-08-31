package jp.ac.it_college.s20022.quiz


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.opencsv.CSVIterator
import com.opencsv.CSVReader
import jp.ac.it_college.s20022.quiz.databinding.ActivityQuizMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.ceil

class QuizMain : AppCompatActivity() {
    private lateinit var binding: ActivityQuizMainBinding

    companion object{
        private const val COUNT_DOWN_MILLISECOND: Long = 10000
        private const val INTERVAL_MILLIDECOND: Long = 1000
    }
    var qnum = 1
    var coscore = 0
    var uncscore = 0
    var cleatime = 0
    val countT = findViewById<TextView>(R.id.timerText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quizList: MutableList<Array<String>> = mutableListOf()
        val fileReader = BufferedReader(InputStreamReader(assets.open("quiztext.csv")))
        val csvIter = CSVIterator(CSVReader(fileReader))
        for(row in csvIter){
            if(row == null) break

            row.toString().split(",").toTypedArray()
            quizList.add(row)
        }
        val quiztext = findViewById<TextView>(R.id.quizfragmText)
        val ansbutton = findViewById<TextView>(R.id.aButton)
        val ansbutton2 = findViewById<TextView>(R.id.aButton2)
        val ansbutton3 = findViewById<TextView>(R.id.aButton3)
        val ansbutton4 = findViewById<TextView>(R.id.aButton4)
        var judgement = findViewById<TextView>(R.id.judgeText)

        val list: List<Int> = listOf(1,2,3,4)
        val num: List<Int> = list.shuffled()
        val ans = quizList[qnum][1]
        binding.aButton.text = quizList[qnum][1]
        binding.aButton2.text = quizList[qnum][2]
        binding.aButton3.text = quizList[qnum][3]
        binding.aButton4.text = quizList[qnum][4]


        }


        val timer = object:CountDownTimer(COUNT_DOWN_MILLISECOND, INTERVAL_MILLIDECOND)   {
            override fun onTick(millisUntilFinished: Long) {
                val second = ceil(millisUntilFinished / 100.0).toInt()
                countT.text = second.toString()
            }

            override fun onFinish() {
                countT.text= "0"
            }
        }


}