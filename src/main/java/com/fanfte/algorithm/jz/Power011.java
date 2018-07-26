package com.fanfte.algorithm.jz;

/**
 * Created by dell on 2018/7/18
 **/
public class Power011 {

    public static void main(String[] args) {
        double res = new Power011().power(2, -9);
        System.out.println(res);
    }

    double power(double base, int exponent) {
        if(equal(base, 0.0) && exponent < 0) {
            return 0.0;
        }
        double result = 0.0;
        int srcExponent = exponent;
        if(srcExponent < 0) {
            exponent = -exponent;
        }
        result = powerOfUnsignedInt(base, exponent);
        if(srcExponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    double powerOfUnsignedInt(double base, int exponent) {
        double result = 1.0;
        for(int i = 0;i < exponent;i++) {
            result *= base;
        }
        return result;
    }

    private boolean equal(double base, double v) {
        if((base - v > -0.0000001)
                &&(base - v < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }
}
