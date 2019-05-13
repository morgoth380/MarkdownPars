package com.metanit;

public class EmTagProcessor extends Processor {
    public String process(String in){
        int i = 0;
        int index, firstIndex = -1, secondIndex = -1;
        while(i < in.length()){
            index = in.indexOf('*', i);
            if(index != (-1)){
                if(in.charAt(index + 1) != '*'){
                    if(firstIndex == -1){
                        firstIndex = index;
                    }else{
                        secondIndex = index;
                    }
                    i = index + 1;
                    if((firstIndex != -1) && (secondIndex != -1)){
                        in = in.substring(0, firstIndex) + "<em>" + in.substring(firstIndex + 1, secondIndex) + "</em>" + in.substring(secondIndex + 1, in.length());
                        firstIndex = -1;
                        secondIndex = -1;
                    }
                }else{
                    i = index + 2;
                }
            }else{
                break;
            }
        }
       return in;
    }
}
