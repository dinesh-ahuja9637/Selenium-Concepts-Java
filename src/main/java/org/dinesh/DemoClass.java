package org.dinesh;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DemoClass {
    public static void main(String[] args) {
        String name = "Ahuja Dinesh";
        System.out.println("Original name:"+name);
        String[] nameArry = name.split(" ");
        System.out.println("nameArry:"+ Arrays.toString(nameArry));
        StringBuilder stringBuilder= new StringBuilder();
        for(int i=nameArry.length-1;i>=0;i--)
        {
            stringBuilder.append(nameArry[i]);
            stringBuilder.append(" ");
        }
        System.out.println("Reversed name is:"+stringBuilder.toString());
    }
}
