import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StringDemoClass {
    public static void main(String[] args) {
        //charAt
        String s1 = "Welcome to java";
        //Emoclew ot avaj
        String wovels = "aeiou";
        String[] s1_split = s1.split(" ");
        ArrayList<String> reveseString = new ArrayList<>();

        char[] wolvelsArry = wovels.toCharArray();

        System.out.println("s1_split:"+ Arrays.toString(s1_split));

        //StringBuilder obj1 = new StringBuilder();
        int wovelCount;
        for(int i=0;i<s1_split.length;i++)
        {
            HashMap<String,Integer> vowels = new HashMap<>();
           vowels.put("a",0);
            vowels.put("e",0);
            vowels.put("i",0);
            vowels.put("o",0);
            vowels.put("u",0);
            wovelCount = 0;
            StringBuilder obj = new StringBuilder();
            obj.append(s1_split[i]);
            obj.reverse();
            //System.out.print(obj.toString());
            //obj1.append(obj);
            char[] stringCharAyy = s1_split[i].toCharArray();
            int vowelCountForHashmap;
            for(int j=0;j<stringCharAyy.length-1;j++)

            {
                vowelCountForHashmap = 0;
                //wovelCount = 0;
                for(int k=0;k<wolvelsArry.length-1;k++)
                {
                    if(stringCharAyy[j]==wolvelsArry[k]){
                        wovelCount = wovelCount + 1;
                        vowelCountForHashmap = vowelCountForHashmap + 1;
                        if(vowels.containsKey(String.valueOf(wolvelsArry[k]))){
                            vowels.replace(String.valueOf(wolvelsArry[k]),vowelCountForHashmap);
                        }
                        else{
                            vowels.put(String.valueOf(wolvelsArry[k]),vowelCountForHashmap);
                        }
//
                    }
//                    if(wovelCount>0){
//                    vowels.put(String.valueOf(wolvelsArry[k]),wovelCount);}
                }

            }
            System.out.println("Vowles count in "+s1_split[i].toString()+" is:"+wovelCount);
            System.out.println("for string : "+s1_split[i].toString()+" Vowles count in hashMap format is:"+vowels.toString());

            reveseString.add(i, obj.toString());

        }
        //System.out.println(obj1.toString());
        System.out.println("reveseStrin is:"+reveseString.toString());



    }
}
