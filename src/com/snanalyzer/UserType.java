package com.snanalyzer;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: toby
 * Date: 11/27/13
 * Time: 2:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserType {
    Integer userId;
    Set<Integer> friends;
    public UserType(int userId, Set<Integer> friends){
        this.userId = userId;
        this.friends = friends;
    }

    public void print(){
        System.out.printf("ID: %d FriendCount: %d", this.userId, this.friends.size());
        System.out.print('\n');
        for(Integer e: this.friends){
            System.out.printf("%d ", e.intValue());
        }
        System.out.print('\n');
    }


}
