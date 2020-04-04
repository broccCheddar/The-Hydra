# NPC Overhead Dialogue
This plugin adds a few different dialogue features for NPCs

1. Placing dialogue from the dialog box above the corresponding character

2. Add ambient, walking, damage, and death dialogue for NPCs

All ambient, walking, damage, and death dialogue are custom and can changes can be submitted by forking and pushing to this repo. The format used has NPCs separated by categories, so either create a new category in DialogCategories.java or use the pre-existing categories. Individual NPCs can be defined in DialogNpc.java.

Each category has the different types of dialogue stored in String arrays. The plugin will randomly choose which dialogue to use from the array. 

Originally this plugin did not have the dialog box portion in its scope, but Adam convinced me to implement it.

Special thanks to: TheStonedTurtle, Hannah, and Adam.