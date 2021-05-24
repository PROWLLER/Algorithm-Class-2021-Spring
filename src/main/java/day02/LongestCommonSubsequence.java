package day02;
import tools.AlgorithmTools.Pair;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public static String solve(String a, String b){
        Map<Pair<Integer, Integer>, String> memory = new HashMap<Pair<Integer, Integer>, String>();
        return findLCS(a, 0, b, 0, memory);
    }

    private static String findLCS(String a,
                                  int aIndex,
                                  String b,
                                  int bIndex,
                                  Map<Pair<Integer, Integer>, String> memory){
        if(memory.containsKey(new Pair<Integer,Integer>(aIndex, bIndex))){
            return memory.get(new Pair<Integer,Integer>(aIndex, bIndex));
        }

        if(aIndex >= a.length())return "";
        if(bIndex >= b.length())return "";

        if(a.charAt(aIndex) == b.charAt(bIndex)){
            String result = a.charAt(aIndex) +
                    findLCS(a, aIndex + 1, b, bIndex + 1, memory);
            memory.put(new Pair<Integer,Integer>(aIndex, bIndex), result);
            return result;
        }
        else{
            String r1 = findLCS(a, aIndex + 1, b, bIndex, memory);
            String r2 = findLCS(a, aIndex, b, bIndex + 1, memory);
            String result = r1.length() > r2.length() ? r1 : r2;
            memory.put(new Pair<Integer,Integer>(aIndex, bIndex), result);
            return result;
        }
    }
}
