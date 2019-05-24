package com.kb.m2.func;

public class InteroperabilityDemo {

    public static void main(String[] args){
        //var max = FunctionsKt.max(2,3);
        Integer max = Function.max(2,3);

        Function.log1("msg",2);

        //overloaded - default params
        Function.log2("msg",2);
        Function.log2("msg");
    }

}
