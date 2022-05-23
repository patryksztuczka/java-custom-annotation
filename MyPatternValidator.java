package com.application.lab5;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatternValidator implements Validator {

    private MyPattern myPattern;
    private boolean valid = false;

    public MyPatternValidator(MyPattern myPattern){
        this.myPattern = myPattern;
    }

    @Override
    public void validate(String value) {
        Pattern compiledPattern = Pattern.compile(myPattern.regex());
        Matcher matcher = compiledPattern.matcher(value);

        valid = matcher.matches();
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public String getMessage() {
        return myPattern.message();
    }
}
