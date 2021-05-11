TEST = javac -classpath test4poo.jar
FILE =*.java

all: boardTest characterTest playerTest tileTest gameTest

#Compilation des packages

cls:
	make -C src

doc:
	make -C src doc

guerre.jar: cls
	make -C classes war

agricole.jar: cls
	make -C classes agricol

war: guerre.jar
	java -jar guerre.jar

agricol: agricole.jar
	java -jar agricole.jar

#Compilation des tests
boardTest:
	$(TEST) test/game/board/$(FILE)

characterTest: 
	$(TEST) test/game/character/$(FILE)

playerTest:
	$(TEST) test/game/player/$(FILE)

tileTest:
	$(TEST) test/game/tile/$(FILE)

gameTest:
	$(TEST) test/game/game/$(FILE)


# Utile
clean :
	rm -f -r classes/game docs

.PHONY: clean doc cls
