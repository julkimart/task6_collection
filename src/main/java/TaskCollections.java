/**
 * Поместить файл listOfWords.txt на диск D
 * Данное задание номер 6 выполнено двумя способами: через arrayList и через hashMap
 */


import java.io.File;

import java.io.IOException;
import java.util.Collections;
import java.util.*;

public class TaskCollections {


    public static void main(String[] args) throws IOException {


        System.out.println("Первый вариант: текст из файла ArrayList\n");

        Scanner scanner = new Scanner(new File("D:\\listOfWords.txt"));
        List<String> words = new ArrayList<String>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();
        System.out.print("Слова из файла: " + words + " \n");
        //считала из файла слова в лист


        Collections.sort(words);
        System.out.print("Слова по алфавиту: " + words + " \n\n");
        //отсортировала в алфавитном порядке


        int max = 0;
        String frequentWord = null; //часто встречающееся слово и количества его повторений

        for (int n = 0; n < words.size(); n = 0) {
            int count = 0;
            String oneWordFromList = words.get(n);
            Iterator<String> iter = words.iterator();
            while (iter.hasNext()) {
                String anotherWord = iter.next();
                if (oneWordFromList.equals(anotherWord)) {
                    count++;
                    if (max < count) {
                        max = count;
                        frequentWord = oneWordFromList;
                    } //нашла слово с максимальным количеством повторений
                    iter.remove();
                }
            }
            System.out.println(oneWordFromList + " : " + count);
        }
        //вывела количество каждого слова в тексте

        System.out.println("\nСлово с максимальным количеством повторений — <" + frequentWord + ">, количество его повторений = " + max);


        System.out.println("\nВторой вариант: текст из файла HashMap\n");

        Scanner scanner2 = new Scanner(new File("D:\\listOfWords.txt"));
        Map<String, Integer> anotherRealization = new HashMap<>();
        while (scanner2.hasNext()) {
            String wordInMap = scanner2.useDelimiter("\\s+").next();
            Integer count = anotherRealization.get(wordInMap);
            if (count == null) {
                count = 0;
            }
            anotherRealization.put(wordInMap, ++count);
        }
        System.out.println("Слово и количество его повторений: " + anotherRealization);


        int max2 = 0, oneCount = 0;
        String oneWord, thatWord = null;


        for (Map.Entry entry : anotherRealization.entrySet()) {
            oneWord = (String) entry.getKey();
            oneCount = (int) entry.getValue();

            if (max2 < oneCount) {
                max2 = oneCount; thatWord = oneWord;
            }
        }

        System.out.println("Слово с максимальным количеством повторений — <" + thatWord + ">, количество его повторений = " + max2);


    }


}


