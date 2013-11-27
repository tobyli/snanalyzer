package com.snanalyzer;

import java.io.FileReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: toby
 * Date: 11/27/13
 * Time: 2:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserParser {

    String fileName;
    FileReader fileReader;
    Scanner scanner;
    public UserParser(String fileName) throws Exception{
        this.fileName = fileName;
        fileReader = new FileReader(fileName);
        scanner = new Scanner(fileReader);
    }

    public Map<Integer, UserType> parse(){
        String line = new String();
        Scanner lineScanner;
        Map<Integer,UserType> result = new HashMap<Integer, UserType>();
        int counter = 0;
        while(scanner.hasNextLine()){
            counter++;
            if(counter % 10000 == 0)
                System.out.println(counter);
            line = scanner.nextLine();
            lineScanner = new Scanner(line);
            int a = lineScanner.nextInt();
            int b = lineScanner.nextInt();
            if(result.containsKey(a)){
                result.get(a).friends.add(b);
            }
            else{
                UserType userType = new UserType(a, new HashSet<Integer>());
                userType.friends.add(b);
                result.put(a, userType);
            }
            if(result.containsKey(b)){
                result.get(b).friends.add(a);
            }
            else{
                UserType userType = new UserType(b, new HashSet<Integer>());
                userType.friends.add(a);
                result.put(b, userType);
            }
        }
        System.out.println("Finish Parsing :)");
        return result;
    }

}
