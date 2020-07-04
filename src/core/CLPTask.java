
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import JaCoP.constraints.*;
import JaCoP.core.*;
import JaCoP.search.*;
import java.util.HashMap;
/**
 *
 * @author Krzysztof Kramarz
 */
public class CLPTask {
    Store store = new Store();
    IntVar[] sentence;
    IntVar afterNoun; //1 example: "DOG"
    IntVar afterVerb; //2 "WALKING"
    IntVar afterAdjective; //3 "BEAUTIFULL"
    IntVar afterPrefix; //4 "THE"
    IntVar afterAdverb; //5 "VERY"
    IntVar afterConjunction; //6 "AND" //do podzielenia na przypadki
    IntVar endOfTheSentence; //7 "."
    IntVar[] grammar;
    IntVar wrongStarts;
    //String[] words;
    
    protected Search search = new DepthFirstSearch();
    public void model(int sentenceLenght){
        
//        String[] words = {"I","dog", "man", "the", "walks","walk", "and", "very", "beautiful", "love", "sun", "shines"};
//        //int[] types = {1, 1, 1, 4, 2, 2, 6, 5, 3, 1, 1, 3};
//        
//        IntVar[] types = {new IntVar(store, "I", 1, 1), 
//                            new IntVar(store, "dog",1, 1), 
//                            new IntVar(store, "man",1, 1), 
//                            new IntVar(store, "the",4, 4), 
//                            new IntVar(store, "walks",2, 2), 
//                            new IntVar(store, "walk",2, 2),
//                            new IntVar(store, "and",6, 6),
//                            new IntVar(store, "very",5, 5),
//                            new IntVar(store, "beautiful",3, 3),
//                            new IntVar(store, "love",1, 1),
//                            new IntVar(store, "sun",1, 1),
//                            new IntVar(store, "shines",3, 3)};
//        
//        IntVar[] person = {new IntVar(store, "I", 1, 1), 
//                            new IntVar(store, "dog",3, 3), 
//                            new IntVar(store, "man",3, 3), 
//                            new IntVar(store, "the",2, 3), 
//                            new IntVar(store, "walks",3, 3), 
//                            new IntVar(store, "walk",1, 2),
//                            new IntVar(store, "and",1, 3),
//                            new IntVar(store, "very",1, 3),
//                            new IntVar(store, "beautiful",1, 3),
//                            new IntVar(store, "love",1, 3),
//                            new IntVar(store, "sun",3, 3),
//                            new IntVar(store, "shines",3, 3)};
//
//        
//        
//        
        
        //creating our grammar
        afterNoun = new IntVar(store, "after noun", 2, 2);
        //afterNoun.addDom(6,6);
        afterNoun.addDom(7,7);
        
        afterVerb = new IntVar(store, "after verb", 1, 1);
        afterVerb.addDom(3,3);
        afterVerb.addDom(4,4);
        afterVerb.addDom(5,5);
        //afterVerb.addDom(6,6);
        afterVerb.addDom(7,7);
        
        afterAdjective = new IntVar(store, "after adjective", 1, 1);
        afterAdjective.addDom(6,6);
        //afterAdjective.addDom(7,7);
        
        afterPrefix = new IntVar(store, "after Prefix", 1, 1);
        afterPrefix.addDom(3,3);
        afterPrefix.addDom(5,5);
        
        afterAdverb = new IntVar(store, "after Adverb", 3, 3);
        afterAdverb.addDom(5,5);
        //afterAdverb.addDom(7,7);

        
        afterConjunction = new IntVar(store, "after Conjunction", 3, 3);
        //afterConjunction.addDom(4,4);
        afterConjunction.addDom(5,5);
        endOfTheSentence = new IntVar(store, "end of the sentence", 7, 7);
        
        grammar = new IntVar[7];
        grammar[0] = afterNoun; 
        grammar[1] = afterVerb; 
        grammar[2] = afterAdjective; 
        grammar[3] = afterPrefix; 
        grammar[4] = afterAdverb; 
        grammar[5] = afterConjunction;
        grammar[6] = endOfTheSentence;
        
        //creating sentence
        sentence = new IntVar[sentenceLenght];
        for(int i = 0; i < sentenceLenght; i++){
            sentence[i] = new IntVar(store, "word " + i, 1,grammar.length);
        }

        
        //creating logic for sentences
        for(int i = 0; i < sentenceLenght - 1; i++){
            store.impose(new Element(sentence[i], grammar, sentence[i+1]));
        }
       store.impose(new XeqY(sentence[sentenceLenght - 1], endOfTheSentence));
       
       store.impose(new XneqY(sentence[0], new IntVar(store, "wrong start", 2, 2)));
       store.impose(new XneqY(sentence[0], new IntVar(store, "wrong start", 6, 6)));
       store.impose(new XneqY(sentence[0], new IntVar(store, "wrong start", 7, 7)));
       // constrain for checking if at least one verb and noune are in the sentence
       // (verb, noun) in S
       PrimitiveConstraint[] c1 = new PrimitiveConstraint[sentenceLenght];
       PrimitiveConstraint[] c2 = new PrimitiveConstraint[sentenceLenght];
       for (int i = 0; i < sentenceLenght; i++){
           c1[i] = new XeqY(sentence[i], new IntVar(store, "wrong start", 1, 1));
           c2[i] = new XeqY(sentence[i], new IntVar(store, "wrong start", 2, 2));
       }
       store.impose(new Or(c1));
       store.impose(new Or(c2));
       
       String String1  = new String("0");
    }
    public Domain[][] search() {
        search.getSolutionListener().searchAll(true);
        search.getSolutionListener().recordSolutions(true);
        SelectChoicePoint select = new SimpleSelect(sentence,  new SmallestDomain(), new IndomainMin());
        search.labeling(store, select);
        //search.printAllSolutions();
        return search.getSolutionListener().getSolutions();
        
    }
    
    public int getNumberOfSolutions(){
        return search.getSolutionListener().getSolutions().length;
    }

    public String returnStoreString() {
        return store.toString();
    }
    
}
    
    

