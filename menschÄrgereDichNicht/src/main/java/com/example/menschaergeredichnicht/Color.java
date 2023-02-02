package com.example.menschaergeredichnicht;

public enum Color {
    RED(255,31,31), GREEN(0,255,13), BLUE(30,144,255), YELLOW(255, 234,31), BLACK(0,0,0);

    private int r;
    private int g;
    private int b;

    Color(int red, int green, int blue) {
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    int getRed() {
        return r;
    }

    int getGreen() {
        return g;
    }

    int getBlue() {
        return b;
    }
}
