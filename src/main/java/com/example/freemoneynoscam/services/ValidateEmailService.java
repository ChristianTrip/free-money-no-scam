package com.example.freemoneynoscam.services;

public class ValidateEmailService {

    public boolean isEmailValid(String email){

        return hasAtAndDotSymbol(email);
    }

    private boolean hasAtAndDotSymbol(String email){

        int atCount = 0;
        int dotCount = 0;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@'){
                atCount ++;
            }
            else if (email.charAt(i) == '.'){
                dotCount ++;
            }
        }

        if (atCount == 1 && dotCount > 0){
            return true;
        }
        System.out.println("'@' count:" + atCount);
        System.out.println("'.' count:" + dotCount);
        return false;
    }
}
