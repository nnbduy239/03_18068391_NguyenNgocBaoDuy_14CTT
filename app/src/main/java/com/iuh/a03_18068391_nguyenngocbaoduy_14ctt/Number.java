package com.iuh.a03_18068391_nguyenngocbaoduy_14ctt;

public class Number {
    private double number1;
    private double number2;
    private String title;

    public Number(double number1, double number2, String title) {
        this.number1 = number1;
        this.number2 = number2;
        this.title = title;
    }
    public Number(){

    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
