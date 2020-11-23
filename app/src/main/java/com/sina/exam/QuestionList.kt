package com.sina.exam

import android.content.Context

class QuestionList(context: Context) {
    val questionList: MutableMap<String, Test> = mutableMapOf<String,Test>()

    init {

        val test1=Test(context.getString(R.string.quest1),
            arrayListOf("0","1","5","countless"),1)
        questionList["Math"] = test1
    }
}