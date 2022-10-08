package com.example.meiirzhanapp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database {

    public boolean connectionCl(user u) {
        FirebaseDatabase rootNode;
        DatabaseReference reference;

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("userInfo");

        String uniqueKey = reference.push().getKey();//to get unique Key

        if(uniqueKey == null){
            return false;
        }
        reference.setValue(u);
        System.out.println("error occured");
        return true;
    }


}
