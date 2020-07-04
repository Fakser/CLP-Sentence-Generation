/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Krzysztof Kramarz
 */
public class Word {
    public int type;
    public int person;
    public String wordString;
    
    public Word(String Word, int Type, int Person){
        person = Person;
        type = Type;
        wordString = Word;
    }
}
