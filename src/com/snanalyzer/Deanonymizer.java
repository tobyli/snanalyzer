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
    UserType target, realTarget;
    Map<Integer, UserType> dataSet;
    Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
    int targetSize;
    public Deanonymizer(UserType target, Map<Integer, UserType> dataSet, UserType realTarget){
        this.target = target;
        this.dataSet = dataSet;
        this.realTarget = realTarget;
        this.targetSize = realTarget.friends.size();
    }
    public boolean deanonymize(){

        for(Integer i: target.friends){

            for(Integer e: dataSet.get(i).friends){
                if(! dataSet.get(e).friends.contains(i))
                    continue;
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
            if(counterMap.get(e)  > maxCount){

                maxCount = counterMap.get(e);
                //System.out.println(maxCount);
                maxId = e;
            }
        }
        if(maxId == target.userId){
            System.out.printf("%d %d\n", maxCount, targetSize);
            return true;
        }

        else
            return false;


    }

    public boolean deanonymize2(){

        for(Integer i: target.friends){

            for(Integer e: dataSet.get(i).friends){
                if(! dataSet.get(e).friends.contains(i))
                    continue;
                if(counterMap.containsKey(e)){
                    counterMap.put(e, counterMap.get(e) + 1);
                }
                else{
                    counterMap.put(e, 1);
                }
            }
        }
        double maxCount = 0;
        int maxId = 0;
        for(Integer e: counterMap.keySet()){
            if((double)counterMap.get(e) / (double)targetSize  > maxCount){

                maxCount = (double)counterMap.get(e) / (double)targetSize;
                //System.out.println(maxCount);
                maxId = e;

            }
        }
        if(maxId == target.userId){
            //System.out.printf("%d %d T\n", counterMap.get(maxId), targetSize);
            return true;
        }

        else{
            //System.out.printf("%d %d %d F\n", counterMap.get(maxId), targetSize, target.friends.size());
            return false;
        }

    }
}
