package com.metanit;

public class ParagraphProcessor extends Processor {
    public String process(String in){
        if(in.charAt(0) != '#'){ //если нет тега заголовка, то по-любому строку нужно поместить в тег <p>
            return "<p>" + in + "</p>";
        }
        return in;
    }

}
