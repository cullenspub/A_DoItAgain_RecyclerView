package com.cjd.learning.recycleviewpractise;

/**
 * Created by cdavis on 2/6/18.
 */

class Crime {
    private int mId;
    private String mName;

    public Crime(int id, String name) {
        mId = id;
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

}
