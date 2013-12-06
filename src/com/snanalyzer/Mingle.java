package com.snanalyzer;

import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: toby
 * Date: 11/27/13
 * Time: 3:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Mingle {
    UserType target;
    Set<Integer> domainSet;
    Map<Integer,UserType> result;
    public  Mingle(UserType target, Set<Integer> domainSet, Map<Integer,UserType> result) throws CloneNotSupportedException{
        this.target = (UserType)target.clone();
        this.domainSet = domainSet;
        this.result = result;
    }

    public static Integer getRandom(Set<Integer> set){
        int size = set.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(Integer obj : set)
        {
            if (i == item)
                return obj;
            i = i + 1;
        }
        return -1;
    }

    public UserType randomMingle(int count){
        for(int i = 0; i < count; i ++){
            target.friends.add(getRandom(domainSet));
        }
        //System.out.println("Finish Mingling");
        return target;

    }

    public UserType userMingle(int count){
        for(int i = 0; i < count; i ++){
            int randomUser = getRandom(domainSet);
            target.friends.addAll(result.get(randomUser).friends);
        }
        //System.out.println("Finish Mingling");
        return target;
    }


}
