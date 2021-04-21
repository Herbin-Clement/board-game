REP =-d ../classes
FILE =*.java
 
all: game board character exception player tile utils

# Génération de la documentation

doc:
	javadoc -d ../docs -subpackages  game

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

utils:
	javac game/utils/$(FILE) $(REP)

game:
	javac game/Game.java $(REP)
	javac game/AgricolGame.java $(REP)
	javac game/WarGame.java $(REP)
	

.PHONY: doc all
