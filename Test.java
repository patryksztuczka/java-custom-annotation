package com.application.lab5;

public class Test {
    @MyPattern(regex = "correct value", message = "This value is not correct!")
    private String beanText;

    public Test(String beanText) {
        this.beanText = beanText;
    }

    public String getBeanText() {
        return beanText;
    }

    public void setBeanText(String beanText) {
        this.beanText = beanText;
    }
}
