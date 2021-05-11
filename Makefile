TEST = javac -classpath jar/test4poo.jar
FILE =*.java

all: boardTest characterTest playerTest tileTest 

#Compilation des packages

cls:
	make -C src

doc:
	make -C src doc

guerre.jar: cls
	make -C classes war
	mv guerre.jar jar/

agricole.jar: cls
	make -C classes agricol
	mv agricole.jar jar/

war: guerre.jar
	java -jar jar/guerre.jar

agricol: agricole.jar
	java -jar jar/agricole.jar

#Compilation des tests
boardTest: 
	$(TEST) test/game/board/$(FILE)

characterTest: 
	$(TEST) test/game/character/$(FILE)

playerTest: 
	$(TEST) test/game/player/$(FILE)

tileTest:
	$(TEST) test/game/tile/$(FILE)


# Utile
clean :
	rm -f -r classes/game docs

.PHONY: clean doc cls
