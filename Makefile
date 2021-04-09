TEST = javac -classpath test4poo.jar
FILE =*.java

all: boardTest characterTest playerTest tileTest gameTest

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

