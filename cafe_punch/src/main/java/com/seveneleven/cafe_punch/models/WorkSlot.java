package com.seveneleven.cafe_punch.models;

public class WorkSlot {
    int wsID;
    String date;
    String startTime;
    String endTime;
    int noOfCashier;
    int noOfChef;
    int noOfWaiter;

    public WorkSlot() {
    }

    public WorkSlot(int wsID, String date, String startTime, String endTime,  int noOfCashier, int noOfChef, int noOfWaiter) {
        this.wsID = wsID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfCashier = noOfCashier;
        this.noOfChef = noOfChef;
        this.noOfWaiter = noOfWaiter;
    }

    public int getWsID() {
        return wsID;
    }
    public void setWsID(int wsID) {
        this.wsID = wsID;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public int getNoOfCashier() {
        return noOfCashier;
    }
    public void setNoOfCashier(int noOfCashier) {
        this.noOfCashier = noOfCashier;
    }
    public int getNoOfChef() {
        return noOfChef;
    }
    public void setNoOfChef(int noOfChef) {
        this.noOfChef = noOfChef;
    }
    public int getNoOfWaiter() {
        return noOfWaiter;
    }
    public void setNoOfWaiter(int noOfWaiter) {
        this.noOfWaiter = noOfWaiter;
    }

}
