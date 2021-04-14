package com.sunil.leetcode.dd;

/**
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 *
 * Implement the BrowserHistory class:
 *
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x,
 * you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x,
 * you will forward only x steps. Return the current url after forwarding in history at most steps.
 */

public class BrowserHistory {
    private String[] history;
    private int curr;
    private int max;

    public BrowserHistory(String homepage) {
        history = new String[5001];
        history[0] = homepage;
        curr = 0;
        max = 0;
    }

    public void visit(String url) {
        curr++;
        history[curr] = url;
        max = curr;
    }

    public String back(int steps) {
        if(curr - steps < 0) {
            curr = 0;
            return history[0];
        }
        curr = curr - steps;
        return history[curr];
    }

    public String forward(int steps) {
        if(curr + steps > max){
            curr = max;
            return history[max];
        }
        curr = curr + steps;
        return history[curr];
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("google.com");
        browserHistory.visit("gmail.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
    }
}