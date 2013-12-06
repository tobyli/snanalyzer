package com.snanalyzer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: toby
 * Date: 11/27/13
 * Time: 2:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserType implements Cloneable {
    Integer userId;
    Set<Integer> friends;
    public UserType(int userId, Set<Integer> friends){
        this.userId = userId;
        this.friends = friends;
    }
    public UserType(UserType userType){
        this.userId = new Integer(userType.userId.intValue());
        Integer temp[] = new Integer[1000];
        System.arraycopy(userType.friends.toArray(), 0, temp, 0, userType.friends.size());
        this.friends = new HashSet<Integer>();
        for(int i = 0; i < userType.friends.size(); i++){
            friends.add(temp[i]);
        }
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
