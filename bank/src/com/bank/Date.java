package com.bank;

public class Date {
    private int day;
    private int month;
    private int year;


    public Date(){};

    public Date(int day, int month, int year){
        if(day<=19 && month <=10 && year==2021){
                this.day = day;
                this.month = month;
                this.year = year;
            } else if(day<32 && month <13 && year<2021){
                this.day = day;
                this.month = month;
                this.year = year;
            } else {
                System.out.println("Date is not valid!");
        }


    }
    

    public String getDate(){ return this.day+"."+this.month+"."+this.year;
    }



    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLeapYear(){

        if ((this.year % 4 == 0) && this.year % 100 != 0)
        {
            return true;
        }
        else if ((this.year % 4 == 0) && (this.year % 100 == 0) && (this.year % 400 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
