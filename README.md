# SENTENCE GENERATION

## CLP PROJECT REPORT

### Krzysztof Kramarz


## *Topic of the project*

### For my project i’ve chosen “Generation of random grammatically good sentences”

## *Short description*

### Problem of sentence generation is being widely researched by many NLP enthusiasts.

### Let’s say you are writing an article with many paragraphs in it. And you do not want to waste

### time to name every one of them. With sentence generation you can create headlines for those

### paragraphs automatically, based on a “dictionary” of words that were used in them. I’ve based

### my idea on NLTK context-free grammar. However, as this idea was not ideal for me I've made

### some twists around their idea.

### Context-Free grammar is a pretty easy and straight-forward idea. We provide the generator all

### possible sentence variations, ex. sentence = Noun + “is walking” or sentence = Noun + “walk”.

### Additionally we provide the code with some dictionary of words that can be used in a given

### group, ex. NOUNS = {“man”,”dog”, “tree” }.

#### Fig 1. Graphical explanation of context-free grammar.


### My Idea was to use CLP for generation of such possible variations. Also it would be nice if the

### solver would choose proper tenses (past-simple, past-continuous) and use proper rulers and

### verbs.

## *Implementation*

### First I’ve managed to create a solver that creates all possible grammatical structures of

### sentences based on provided grammar and maximal sentence length. Right now grammar is

### hardcoded, but it will be possible to pass it as an argument for the solver in .json format.

### Grammar has a structure of so-called recursive trees. Sentence starts with random word type.

### Each type has some other types that can follow it. I have also added some original constraints

### to be sure that each sentence has judgment and entity.




#### Fig 2. Example of recursive tree grammar.

### CLP solver returns all grammatically possible structures of sentences. But these are just

### numbers, not something readable for us, casual humans. Thus I have implemented a simple

### algorithm for changing numbers into correct words. Each word is represented by class ​Word​,


### which stores its string representation, integer representing its type and integer for person (ex.

### First person “I”, Second person “You” etc.).


### Such words are stored in a list. To make my code as close to logic programming as possible,

### choosing proper random words from the list is done by lambda functions.



### As one can see, some words are duplicated. It is because some of them belong to more than

### one group. I’ve decided to solve this problem like the M:N database relation.

### MyApp.main() can be completely refactorized to another class, which could be a part of a bigger

### application. But in this project I wanted to make research, thus it is written in such a way.

## *Conclusions and possible future innovations*

### I am pretty satisfied with current progress and I am impressed how fast my generator is. Even if

### I have not used any especially hard-to-compute constraints (mostly Element), the solver still

### needs to check thousands of possibilities. By constraining each sentence with the fact that it

### needs to have at least one verb and noun I've got really satisfying results.

#### Fig 3. and 4. Examples of program output.

### Thanks to this project I have a small private library for NLP and logic programming concerning

### sentence generation. Big merit for it is that it can be easily modified. One of many possible

### modifications will be tenses control, which right now is extremely easy to add. All that needs to

### be done is to create variable “tense” in class “Word” and to add more words into the dictionary.

### During the following free time I will definitely experiment around creating more strict grammar

### concerning tenses, also I will make it more usable for casual users. As this is the final report

### from the CLP subject, my future work can be seen on my github: ​https://github.com/Fakser​, as

### well on my Linkedin: ​https://www.linkedin.com/in/krzysztof-kramarz-6013b81a2​. Repository for

### this project will be created In a couple of days. If there is any interest in some future cooperation

### I encourage contacting me via email ​krzysztof.kraamarz@gmail.com​, or any other source like

### already mentioned Linkedin/Github.



