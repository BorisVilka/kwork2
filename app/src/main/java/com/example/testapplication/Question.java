package com.example.testapplication;

import java.io.Serializable;

public class Question implements Serializable {

    public String text;
    public String[] ans;
    public int ind;

    public Question(String text, String[] ans, int ind) {
        this.text = text;
        this.ans = ans;
        this.ind = ind;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getAns() {
        return ans;
    }

    public void setAns(String[] ans) {
        this.ans = ans;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }
}
