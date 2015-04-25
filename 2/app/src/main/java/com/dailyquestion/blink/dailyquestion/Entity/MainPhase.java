package com.dailyquestion.blink.dailyquestion.Entity;

import com.orm.SugarRecord;

/**
 * Created by peyman on 4/22/15.
 */
public class MainPhase extends SugarRecord<MainPhase> {
    int level;
    int star;
    int color;
    boolean lock;

    public MainPhase(int level, int star, int color, boolean lock) {
        this.level = level;
        this.star = star;
        this.color = color;
        this.lock = lock;
    }

    public MainPhase() {
    }
}
