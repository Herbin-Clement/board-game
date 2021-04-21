REP =-d ../classes
FILE =*.java

all: game board character exception player tile 

# Compilation des différents package
board: 
	javac game/board/$(FILE) $(REP)

character: 
	javac game/character/$(FILE) $(REP)

exception:
	javac game/exception/$(FILE) $(REP)

player:
	javac game/player/$(FILE) $(REP)

tile:
	javac game/tile/$(FILE) $(REP)

game:
	javac game/Game.java $(REP)
	javac game/AgricolGame.java $(REP)
	javac game/WarGame.java $(REP)
	


