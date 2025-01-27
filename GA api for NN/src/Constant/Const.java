package Constant;

import java.util.function.Function;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahmud
 */
public abstract class Const {

    public static final int MAX = 1;
    public static final int MIN = -1;
//    public static double MAXIMUM = 1;
//    public static double MINIMUM = -1;
//    public static double MUTATION_MAXIMUM = 50;
//    public static double MUTATION_MINIMUM = -50;
    public static Range[] ranges;
    public static int var_count = 1;
    public static int TYPE_DATA = 0; // 0 = double type  | 1 = int type
    public static int TYPE_PR = 0; // 0 = non unique Problem | 1 = unique Problem
    public static int Double_DATA = 0; // 0 = double type  | 1 = int type
    public static int INT_DATA = 1; // 0 = non unique Problem | 1 = unique Problem
    public static final int NON_UNIQUE_PR = 0; // 0 = non unique Problem | 1 = unique Problem
    public static final int UNIQUE_PR = 1; // 0 = non unique Problem | 1 = unique Problem

    private static int Search = 0;
    private static Functions<Double, Double> function2;
//    for Conditions
    private static Condition<Double> conditions[];

    public static void setTYPE_DATA(int TYPE_DATA) {
        Const.TYPE_DATA = TYPE_DATA;
    }

    public static void setTYPE_PR(int TYPE_PROBLEM) {
        Const.TYPE_PR = TYPE_PROBLEM;
    }

//    public static void setRange(double Min, double Max) {
//        Const.MINIMUM = Min;
//        Const.MAXIMUM = Max;
//    }
    public static void setRanges(Range[] range) {
        Const.ranges = range;
    }

//    public static void setMutationRange(double Min, double Max) {
//        MUTATION_MINIMUM = Min;
//        MUTATION_MAXIMUM = Max;
//    }
    public static void setFunction(Functions<Double, Double> function) {
        Const.function2 = function;
    }

    public static void setSearch(int Search) {
        Const.Search = Search;
    }

    public static int getSearch() {
        return Search;
    }

    public static void setVar_count(int var_count) {
        Const.var_count = var_count;
    }

    public static double compute(Double... x) {
//        if(x.length!=var_count)
//            throw new UnsupportedOperationException("deyisenlerin sayi teyin edilenden azdir");
        if (!computeConditions(x)) {
            switch (Search) {
                case MAX:
                    return Double.MIN_VALUE;
                case MIN:
                    return Double.MAX_VALUE;
            }
        }
        return function2.compute(x);
    }

    public static void setConditions(Condition<Double>... conditions) {
        Const.conditions = conditions;
    }

    public static boolean computeConditions(Double... x) {
        if (conditions != null) {
            for (int i = 0; i < conditions.length; i++) {
                if (!conditions[i].compute(x)) {
                    return false;
                }
            }
        }
        return true;
    }

}


