package org.dinesh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        boolean flag = true;
        Pattern pattern = Pattern.compile("\\s",Pattern.CASE_INSENSITIVE);
        String name = "My name is Dinesh";
        String[] nameArray = name.split(" ");
        String space = " ";
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("original name is:"+name);
        for(int i=nameArray.length-1;i>=0;i--)
        {
            stringBuilder.append(nameArray[i]);
            if(i==0){break;}
            stringBuilder.append(space);
        }
        System.out.println("reverse name is:"+stringBuilder);
        //Dinesh is name My
        Matcher matcher = pattern.matcher(name);
        if(matcher.find())
        {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

    }
}
