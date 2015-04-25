package com.dailyquestion.blink.dailyquestion.Entity;

import com.orm.SugarRecord;

/**
 * Created by peyman on 4/22/15.
 */
public class Question extends SugarRecord<Question> {
    String name;
    MainPhase level;
    int type;
    String text;
    String img;

    public Question(String name, MainPhase level, int type, String text, String img) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.text = text;
        this.img = img;
    }

    public Question() {
    }
}
