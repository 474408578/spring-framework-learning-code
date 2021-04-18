package com.xschen.spring.aop.f_introduction.validator;

/**
 * @author xschen
 */
public class MoneyValidatorImpl implements MoneyValidator{
    @Override
    public boolean validate(int money) {
        return money > 0;
    }
}
