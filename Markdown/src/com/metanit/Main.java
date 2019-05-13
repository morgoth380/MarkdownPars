package com.metanit;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	    String tempInput[] = new String[1000]; //!Временный массив
        String b[];
        String strLine;
        int i = 0;
        Processor [] tagProcessors = {new ParagraphProcessor(), new HeaderProcessor(),new EmTagProcessor(),
                new StrongTagProcessor(), new LinkProcessor()}; //!Массив обработчиков
        try{
            FileInputStream fstream = new FileInputStream("testFile.txt"); //Файл с исходным кодом
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            while ((strLine = br.readLine()) != null){ //!Читаем построчно файл
                tempInput[i] = strLine; //!Сохраняем считанную строку во временном массиве строк
                i++; //после выхода из цикла i будет равно коли количеству считанных строк
            }
            b = new String[i]; //!создаем новый массив
            for(int j = 0; j < i; j++){ //!Копируем строки из временного массива в только-что созданный
                b[j] = tempInput[j];
            }

            //!Обработка массива строк. Каждому из обработчиков передаем все строки
            for(int k = 0; k < tagProcessors.length; k++){
                for(i = 0; i < b.length; i++){
                    b[i] = tagProcessors[k].process(b[i]); //!Результат обработки - новая измененная строка
                }
            }

            //Пишем результат в новый файл
            try {
                FileOutputStream outStream = new FileOutputStream("outFile.txt");
                for(i = 0; i < b.length; i++){
                    byte[] buffer = b[i].getBytes();
                    outStream.write(buffer, 0, buffer.length);
                    outStream.write('\n');
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
