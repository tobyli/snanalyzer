package com.snanalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: toby
 * Date: 11/27/13
 * Time: 3:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Deanonymizer {
    UserType target;
    Map<Integer, UserType> dataSet;
    Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
    public Deanonymizer(UserType target, Map<Integer, UserType> dataSet){
        this.target = target;
        this.dataSet = dataSet;
    }
    public boolean deanonymize(){

        for(Integer i: target.friends){

            for(Integer e: dataSet.get(i).friends){
                if(counterMap.containsKey(e)){
                    counterMap.put(e, counterMap.get(e) + 1);
                }
                else{
                    counterMap.put(e, 1);
                }
            }
        }
        int maxCount = 0;
        int maxId = 0;
        for(Integer e: counterMap.keySet()){
            if(counterMap.get(e) > maxCount){
                    maxCount = counterMap.get(e);
                    maxId = e;
            }
        }
        if(maxId == target.userId)
            return true;
        else
            return false;


    }
}
