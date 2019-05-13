package com.metanit;

public class LinkProcessor extends Processor {
    public String process(String in){
        int startStrIndex = 0;
        while(startStrIndex < in.length()){
            int httpIndex = in.indexOf("http", startStrIndex);
            if(httpIndex == -1){ //если строка http не найдена, выходим из анализа строки
                break;
            }else{//иначе, строка http найдена
                int leftScobeIndex = httpIndex - 1; //leftScobeIndex указывает на открывающую скобку
                int rightScobeIndex = in.indexOf(")", httpIndex); //ищем закрывающую скобку
                if(rightScobeIndex != -1){ //если закрывающая скобка найдена, ok
                }
                //далее ищем открывающую квадратную скобку
                int squareIndex = in.indexOf("[", startStrIndex);
                in = in.substring(0/*startStrIndex*/, squareIndex) + "<a href=\"" + in.substring(leftScobeIndex + 1, rightScobeIndex) +
                        "\">" + in.substring(squareIndex + 1, leftScobeIndex - 1) + "</a>" +
                        in.substring(rightScobeIndex + 1);
                startStrIndex = in.lastIndexOf("</a>"); //!Строка изменена. Поиск последующих ссылок после только-что вставленной
            }
        }
        return in;
    }


}

