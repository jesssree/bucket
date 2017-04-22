Jessica Gary
jsg2213 
HW 4 

Programming Part 1: 
FILES NEEDED: word.txt, filetospellcheck.txt, and SpellChecker.java
COMMAND LINE: java SpellChecker words.txt filetobespellcheck.txt 

The objective of the program is to construct a spell checker and passing into the program two command line arguments, one is the dictionary file and the other is the file to be checked for spelling errors. The program will print out the word that is incorrectly spelled as well as the line in which it occurs. In parentheses, next to the wrongly spelled word is a list of suggestions. 

Constructing a hash table out of the input dictionary file. ****************************
- I parsed through the file containing correctly spelled words 
- For each of the word, it becomes both the key and the value of a hash map. 
	- lowercase all words before hashing it. 
- To search for a word (value + key) in the hash map, I just used .containsValue() and .containsKey(), which will return a boolean. True if the word is found, false otherwise. 

checkTextFile method:*********************************************************
- accepts a string, which is the text file name that we want to check the spelling of
- reading in one line at a time from the file, then tokenize the string into individual words using regex to get rid of all the white spaces. 
- check each of the tokens against the dictionary 
	—> check() method has 3 tiers
		- 1) check the raw word against the dictionary
		- 2) if not found in (1), check again with all lowercase 
		- 3) if not found in (2), check again without punctuations
		- If word still not found, return false. 
	-> If word not found, call suggestWords method 
	-> suggestWords method calls 5 private methods, each of which play around with the word, then check them against the dictionary, then prints out the suggestions for the misspelled word  being passed to them. 


Suggestions for a new word: *********************************************************
- Add a character to the front of the misspelled word, then check it newly-formed word against the dictionary hash table.
- Add a character to the back of the misspelled word, then check it newly-formed word against the dictionary hash table.
- Remove a character from the front of the misspelled word, then check the dictionary with it.
- Remove a character from the back of the misspelled word, then check the dictionary again. 
- Form new words by alternating the characters in a word and check them against the dictionary. 
- If any of these methods found the newly-formed word in the dictionary, they print out the suggestions. 


I chose not to do Programming Project #2 
