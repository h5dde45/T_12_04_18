package com.t3.p4;

import java.util.Objects;

public class CalcImpl implements Calc {

    /**
     * @param expression
     * @return
     * @throws NullPointerException when <code>expression</code> is null
     */
    @Override
    public double calculate(String expression) throws EvException {
        Objects.requireNonNull(expression,"expression is null");
        if(expression.contains("~")){
            throw new EvException("unsupported operator '~'");
        }
//        foo(expression);
        return 0;
    }

//    private String foo(String expression) {
//        return bar(expression);
//    }
//
//    private String bar(String expression) {
//        return expression.toString();
//    }
}
