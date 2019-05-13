package com.metanit;

public class HeaderProcessor extends Processor {
    public String process(String in){
        String out = in;
        int i;
        if(in.charAt(0) == '#'){ //признак заголовка всегда стоит вначале строки
            for(i = 0; i < 6; i++){
                if(in.charAt(i) == '#'){

                }else{
                    break;
                }
            }//После выхода из цикла i будет равно посчитанному количеству символов #
            if(i != 0){ //!если нашли один и более символов #
                out = "<h" + i + ">" + in.substring(i) + "</h" + i + ">";
            }
        }
        return out;
    }
}
