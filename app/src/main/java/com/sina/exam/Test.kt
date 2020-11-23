package com.sina.exam

data class Test(
    val question: String,
    val optionsArrayList: ArrayList<String>,
    val correctAnswerIndex: Int
) {
    //5 means non of the options have not been chosen ...default
    var selectedAnswerIndex:Int?=5


    fun testEvaluate():String{
        if(selectedAnswerIndex!=5){
            if(selectedAnswerIndex==correctAnswerIndex) return "Correct Answer..."
            else return "Wrong Answer..."
        }else{
            return "No option chosen"
        }
    }
}