package com.metanit;

public class StrongTagProcessor extends Processor {
    public String process(String in){
        int i = 0;
        int index, firstIndex = -1, secondIndex = -1;
        while(i < in.length()){
            index = in.indexOf("**", i);
            if(index != (-1)){
            {
                if(firstIndex == -1){
                    firstIndex = index;
                }else{
                    secondIndex = index;
                }
                i = index + 2;
                if((firstIndex != -1) && (secondIndex != -1)){
                    in = in.substring(0, firstIndex) + "<strong>" + in.substring(firstIndex + 2, secondIndex) + "</strong>" + in.substring(secondIndex + 2, in.length());
                    firstIndex = -1;
                    secondIndex = -1;
                }
            }
            }else{
                break;
            }
        }
        return in;
    }
}
