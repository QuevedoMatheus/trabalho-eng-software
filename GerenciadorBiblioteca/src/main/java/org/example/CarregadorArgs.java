package org.example;

public class CarregadorArgs {
    private int arg1;
    private int arg2;

    public CarregadorArgs(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public CarregadorArgs(int arg1) {
        this.arg1 = arg1;
    }

    public CarregadorArgs() {
    }

    public int getArg1() {
        return arg1;
    }

    public int getArg2() {
        return arg2;
    }
}
