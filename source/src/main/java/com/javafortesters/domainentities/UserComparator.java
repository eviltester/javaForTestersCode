package com.javafortesters.domainentities;

import java.util.Comparator;

/**
 *  compare users based on username and password
 *
 *  order them by username.length + password.length
 *
 *  where the length comparison == 0, delegate to the String
 *  compareTo for username
 *
 *  return 0 if the same
 *  return negative if o1 is less than o2
 *  return positive if o1 is greater than o2
 */
public class UserComparator implements Comparator {

    public int compare(Object oUser1, Object oUser2) {

        User user1 = (User)oUser1;
        User user2 = (User)oUser2;

        int user1Comparator = user1.getPassword().length() +
                              user1.getUsername().length();

        int user2Comparator = user2.getPassword().length() +
                              user2.getUsername().length();

        int val =  user1Comparator - user2Comparator;

        if(val==0){
            val = user1.getUsername().compareTo(user2.getUsername());
        }

        return val;
    }
}

/*
// add the following line just before return val; to see the comparator in action
   System.out.println("Compare " + user1.getUsername() +
                     " with " + user2.getUsername() + " = " + val);
*/