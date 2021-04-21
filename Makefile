TEST = javac -classpath test4poo.jar
FILE =*.java

all: boardTest characterTest playerTest tileTest gameTest

#Compilation des packages

cls:
	make -C  src

doc:
	make -C src doc



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
	rm -f -r classes docs

.PHONY: clean doc cls
