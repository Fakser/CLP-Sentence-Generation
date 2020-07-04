/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp;

import core.CLPTask;
import core.Word;
import core.Dictionary;
import JaCoP.core.*;
import java.util.Random;
import java.util.List;
/**
 *
 * @author Krzysztof Kramarz
 */
public class MyApp {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //Count
        //Among
        //AmongVar
        //Values
        //GCC
        //Assignment
        // TODO https://stackoverflow.com/questions/24112715/java-8-filter-array-using-lambda?fbclid=IwAR3NuE-CQgTjIRpBvU6TLKHlCajzSl9GBSxPWf3MXXjM8aihZM2wsTa9AV8 DONE
        
        int  MAX_SENTENCE_LENGTH = 10;
        
        Random random = new Random();
        CLPTask solver = new CLPTask();
        solver.model(MAX_SENTENCE_LENGTH);
        Domain[][] solutions = solver.search();
        int numberOfSolutions = solutions.length;
        int solutionIndex;
        while(true){
            solutionIndex = random.nextInt(numberOfSolutions);
            if(solutions[solutionIndex] != null){
                break;
            }
        }
        String randomString = "";
        int newWordType = 0;
        int i = 0;
        Dictionary dict = new Dictionary();
        int person = random.nextInt(3) + 1;
        while(true){
            try
            {
                newWordType = Integer.parseInt(solutions[solutionIndex][i].toString());
            }
            catch(Exception e){
                System.out.println("ERROR");
                System.out.println(solutionIndex);
                System.out.println(solver.getNumberOfSolutions());
                
            }
                
            if(newWordType == 7){
                break;
            }
            i++;
//            Predicate<Word> byType;
//            byType = word -> word.type == newWordType;
            List<Word> words = dict.filterByType(newWordType, person);
            try{        
                randomString += words.get(random.nextInt(words.size())).wordString + " ";
            }catch(Exception e){
                //int index = random.nextInt(words.size());
                randomString += "<OUT>" + " ";
//                System.out.print(newWordType); 
//                System.out.println(person);
            }
        }
        char[] repaired = randomString.toCharArray();
        repaired[0] = Character.toUpperCase(repaired[0]);
        repaired[repaired.length - 1] = '.';
        randomString = new String(repaired);
        System.out.println(randomString);
    }
}
