package day02;

import jdk.swing.interop.SwingInterOpUtils;
import tools.AlgorithmTools;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstring {

    public static String findLCS(String a, String b){
        Map<AlgorithmTools.Pair<Integer, Integer>, String> memory1 = new HashMap<AlgorithmTools.Pair<Integer, Integer>, String>();
        Map<AlgorithmTools.Pair<Integer, Integer>, String> memory2 = new HashMap<AlgorithmTools.Pair<Integer, Integer>, String>();
        String r = findLCS(a, 0, b, 0, memory1, memory2);
        return r;
    }

    private static String findLCS(String a,
                                  int aIndex,
                                  String b,
                                  int bIndex,
                                  Map<AlgorithmTools.Pair<Integer, Integer>, String> indexToStrMemory,
                                  Map<AlgorithmTools.Pair<Integer, Integer>, String> memory){
        if(memory.containsKey(new AlgorithmTools.Pair<Integer,Integer>(aIndex, bIndex))){
            return memory.get(new AlgorithmTools.Pair<Integer,Integer>(aIndex, bIndex));
        }
        if(aIndex >= a.length())return "";
        if(bIndex >= b.length())return "";
        if(a.charAt(aIndex) == b.charAt(bIndex)){
            String r1 = "" + a.charAt(aIndex);
            String r2 = findLCS(a, aIndex+1, b, bIndex+1, indexToStrMemory, memory);

            if(indexToStrMemory.containsKey(new AlgorithmTools.Pair<Integer,Integer>(aIndex+1, bIndex+1))){
                r1 += indexToStrMemory.get(new AlgorithmTools.Pair<Integer,Integer>(aIndex+1, bIndex+1));
            }

            indexToStrMemory.put(new AlgorithmTools.Pair<Integer,Integer>(aIndex, bIndex), r1);

            String result = r1.length()>r2.length()?r1:r2;
            memory.put(new AlgorithmTools.Pair<Integer,Integer>(aIndex, bIndex), result);
            return result;
        }
        else{
            String r1 = findLCS(a, aIndex + 1, b, bIndex, indexToStrMemory, memory);
            String r2 = findLCS(a, aIndex, b, bIndex + 1, indexToStrMemory, memory);
            String result = r1.length() > r2.length() ? r1 : r2;
            memory.put(new AlgorithmTools.Pair<Integer,Integer>(aIndex, bIndex), result);
            return result;
        }

    }
}
