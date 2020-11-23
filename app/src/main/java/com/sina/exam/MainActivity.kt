package com.sina.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var listOfTests:MutableList<Test>
    private var curTest:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test1=Test(getString(R.string.quest1),
            arrayListOf("0","1","5","countless"),1)
        val test2 = Test(
            getString(R.string.quest2),
            arrayListOf("بوینس آیرس", "ساعوپاعولو", "میامی", "ریو دجنیرو"), 3
        )
        listOfTests= mutableListOf(test1,test2)

        setQuestion(curTest)

        var evaluateText:String=""
        evaluateTest.setOnClickListener {
            val rd = radioGroup.checkedRadioButtonId
            val radioButtonTemp=findViewById<RadioButton>(rd)

            if(radioButtonTemp.text== listOfTests[curTest].optionsArrayList[listOfTests[curTest].correctAnswerIndex])
                evaluateText="Correct Answer..."
            else
                evaluateText="Wrong answer..."
            tvShowResult.text=evaluateText
        }
        btnNext.setOnClickListener {
            if (curTest != listOfTests.size ) {
                ++curTest
                setQuestion(curTest)
            }else
                Toast.makeText(this, "It s the last question", Toast.LENGTH_SHORT).show()

        }
        btnBack.setOnClickListener {
            if (curTest != 0) {
                --curTest
                setQuestion(curTest)
            }
        }
    }
    fun setQuestion(testIndex:Int) {
        tvQuestion.text=listOfTests[testIndex].question
        radioButton.text= listOfTests[testIndex].optionsArrayList[0]
        radioButton2.text= listOfTests[testIndex].optionsArrayList[1]
        radioButton3.text= listOfTests[testIndex].optionsArrayList[2]
        radioButton4.text= listOfTests[testIndex].optionsArrayList[3]
    }

}