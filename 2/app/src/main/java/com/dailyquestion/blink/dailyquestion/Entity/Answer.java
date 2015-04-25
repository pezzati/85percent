package com.dailyquestion.blink.dailyquestion.Entity;

import com.orm.SugarRecord;

/**
 * Created by peyman on 4/22/15.
 */
public class Answer extends SugarRecord<Answer> {
    String MainText;
    Question question;
    int percent;
    String answerList;

    public Answer(String mainText, Question question, int percent, String answerList) {
        MainText = mainText;
        this.question = question;
        this.percent = percent;
        this.answerList = answerList;
    }

    public Answer() {
    }
}
