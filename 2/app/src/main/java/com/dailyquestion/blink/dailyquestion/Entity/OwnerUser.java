package com.dailyquestion.blink.dailyquestion.Entity;

import com.orm.SugarRecord;

/**
 * Created by peyman on 4/22/15.
 */
public class OwnerUser extends SugarRecord<OwnerUser> {
    String username;
    int point;
    int coin;

    public OwnerUser(String username, int point, int coin) {
        this.username = username;
        this.point = point;
        this.coin = coin;
    }

    public OwnerUser() {
    }
}
