/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 *
 * @author Krzysztof Kramarz
 */
public class Dictionary {
    
    private List<Word> dictionary = List.of(new Word("I", 1, 3), 
                            new Word("dog",1, 3), 
                            new Word("man",1, 3),
                            new Word("you",1, 2),
                            new Word("I",1, 1),
                            new Word("the",4, 1),
                            new Word("the",4, 3),
                            new Word("this",4, 1),
                            new Word("this",4, 2),
                            new Word("this",4, 3),
                            new Word("a",4, 3), 
                            new Word("walks",2, 3), 
                            new Word("walk",2, 1),
                            new Word("walk",2, 2),
                            new Word("and",6, 1),
                            new Word("and",6, 2),
                            new Word("and",6, 3),
                            new Word("very",5, 1),
                            new Word("very",5, 2),
                            new Word("very",5, 3),
                            new Word("beautiful",3, 1),
                            new Word("beautiful",3, 2),
                            new Word("beautiful",3, 3),
                            new Word("awful",3, 1),
                            new Word("awful",3, 2),
                            new Word("awful",3, 3),
                            new Word("regretful",3, 1),
                            new Word("regretful",3, 2),
                            new Word("regretful",3, 3),
                            new Word("love",1, 3),
                            new Word("sun",1, 3),
                            new Word("shines",2, 3),
                            new Word("shine",2, 1),
                            new Word("shine",2, 2));
    public Dictionary(){}
    
    public List filterByType(int type, int person){
        Predicate<Word> byType = word -> word.type == type && word.person == person;
        List<Word> result = dictionary.stream().filter(byType).collect(Collectors.toList());
        return result;
    } 
    
}
