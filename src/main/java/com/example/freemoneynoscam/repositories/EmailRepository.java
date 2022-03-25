package com.example.freemoneynoscam.repositories;

import com.example.freemoneynoscam.models.Email;

import java.util.ArrayList;

public class EmailRepository {

    public static String fetchSingleEmail(){
        int lastIndex = DataBase.getEmails().size() - 1;
        return DataBase.getEmails().get(lastIndex).getAddress();
    }

    public static ArrayList<Email> fetchlastFourEmails(){
        int indecies = DataBase.getEmails().size();
        ArrayList<Email> fourLastEmails = new ArrayList<>();

        for (int i = indecies - 1; i > indecies - 5; i--) {
            fourLastEmails.add(DataBase.getEmails().get(i));
            System.out.println(DataBase.getEmails().get(i));
        }

        return fourLastEmails;
    }
}
