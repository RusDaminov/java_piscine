import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Program {
    private static String DICTIONARY_FILE_NAME = "dictionary.txt";
    public static void main(String [] argc) {
        if (argc.length != 2) {
            System.out.println("Wrong arguments amount");
            System.exit(-1);
        }
        FileReader fileOne = null;
        FileReader fileTwo = null;
        FileWriter fileDictionaty = null;
        try {
            fileOne = new FileReader(argc[0]);
            fileTwo = new FileReader(argc[1]);
            fileDictionaty = new FileWriter(DICTIONARY_FILE_NAME);
        }
        catch (java.io.FileNotFoundException fileNotFoundException) {
            System.out.println("Can't find file");
            System.exit(-1);
        }
        catch (java.io.IOException ioException) {
            System.out.println("Can't create file " + DICTIONARY_FILE_NAME);
            System.exit(-1);
        }
        BufferedReader bufferOne = new BufferedReader(fileOne);
        ArrayList<Word> fileOneOccurrence = fillArrayFromStream(bufferOne);
        BufferedReader bufferTwo = new BufferedReader(fileTwo);
        ArrayList<Word> fileTwoOccurrence = fillArrayFromStream(bufferTwo);

        fillFromOneToTwo(fileOneOccurrence, fileTwoOccurrence);
        fillFromOneToTwo(fileTwoOccurrence, fileOneOccurrence);


        sort(fileOneOccurrence);
        sort(fileTwoOccurrence);
        try {
            bufferOne.close();
            bufferTwo.close();
            for (int counter = 0; counter < fileOneOccurrence.size(); ++counter) {
                if (!fileOneOccurrence.get(counter).body.isEmpty()) {
                    fileDictionaty.flush();
                    fileDictionaty.write(fileOneOccurrence.get(counter).body + "\n");
                }
            }
            fileDictionaty.close();

        } catch (java.io.IOException ioException) {
            throw new RuntimeException();
        }

        double result = calculateNumerator(fileOneOccurrence, fileTwoOccurrence);
        result = result / calculateDenominator(fileOneOccurrence, fileTwoOccurrence);
        System.out.println("Similarity = " + result);
    }

    private static void sort (ArrayList<Word> dictionary) {
        for (int i = 0; i < dictionary.size(); ++i) {
            for (int j = 0; j < dictionary.size() - 1; ++j) {
                if (dictionary.get(j).body.compareTo(dictionary.get(j + 1).body) > 0) {
                    Word temp = dictionary.get(j);
                    dictionary.set(j,dictionary.get(j + 1));
                    dictionary.set((j + 1), temp);
                }
            }
        }
    }
    private static double calculateDenominator(ArrayList<Word> dictionaryOne, ArrayList<Word> dictionaryTwo) {
        long sumOne = 0;
        for (int counter = 0; counter < dictionaryOne.size(); ++counter) {
            sumOne += (long) dictionaryOne.get(counter).occurrence * dictionaryOne.get(counter).occurrence;
        }
        long sumTwo = 0;
        for (int counter = 0; counter < dictionaryTwo.size(); ++counter) {
            sumTwo += (long) dictionaryTwo.get(counter).occurrence * dictionaryTwo.get(counter).occurrence;
        }
        return Math.sqrt(sumOne) * Math.sqrt(sumTwo);
    }


    private static double calculateNumerator(ArrayList<Word> dictionaryOne, ArrayList<Word> dictionaryTwo) {
        long result = 0;
        for (int counter = 0; counter < dictionaryOne.size(); ++counter) {
            result += (long) dictionaryOne.get(counter).occurrence * dictionaryTwo.get(counter).occurrence;
        }
        return result;
    }

    private static void fillFromOneToTwo(ArrayList<Word> dictionaryOne, ArrayList<Word> dictionaryTwo) {
        for(int counterOne = 0; counterOne < dictionaryOne.size(); ++counterOne) {
            boolean isExist = false;
            for (int counterTwo = 0; counterTwo < dictionaryTwo.size(); ++counterTwo) {
                if (dictionaryOne.get(counterOne).body.equals(dictionaryTwo.get(counterTwo).body)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                dictionaryTwo.add(new Word(dictionaryOne.get(counterOne).body, 0));
            }
        }
    }

    private static ArrayList<Word> fillArrayFromStream(BufferedReader bufferedReader) {
        ArrayList<Word> result = new ArrayList<Word>();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = toLower(line.split("\\W"));
                for (int counter = 0; counter < words.length; ++counter) {
                    boolean isExist = false;
                    for (int resultCounter = 0; resultCounter < result.size(); ++resultCounter) {
                        if (result.get(resultCounter).body.equals(words[counter])) {
                            ++(result.get(resultCounter).occurrence);
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) {
                        result.add(new Word(words[counter], 1));
                    }
                }
            }
        } catch (java.io.IOException ioException) {
            throw new RuntimeException();
        }
        return result;
    }
    private static String [] toLower(String [] array) {
        for (int counter = 0; counter < array.length; ++counter) {
            for (int charCounter = 0; charCounter < array[counter].length(); ++charCounter) {
                if (array[counter].toCharArray()[charCounter] >= 'A' && array[counter].toCharArray()[charCounter] <= 'Z') {
                    char [] tempArray = array[counter].toCharArray();
                    tempArray[charCounter] += 'a' - 'A';
                    array[counter] = new String(tempArray, 0, tempArray.length);
                }
            }
        }
        return array;
    }
}
