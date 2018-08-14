# -Text-Adventure-Game-CSC-241

Final Project from CSC241: Abstract Data Types and Programming Methodology

Description: 

The virtual world consists of rooms that are connected with doors, and creatures. Every room can have at
most four doors, connecting it to its neighbors on the North, South, East, or West. Creatures can move between rooms.

There are three types of creatures: PC, NPCs, animals. 
There is only one player character. There can be multiple NPCs or animals.

Rooms can be dirty, half-dirty, or clean.
Animals want their rooms to be clean; NPCs want their rooms to be dirty; the PC doesn't care. Animals will only stay in
rooms that are clean or half-dirty, NPCs will only stay in rooms that are dirty or half-dirty. The PC
can stay in any type of room. 

The PC has a “respect” parameter, which represents how much all other creatures in the world respect the PC. 
The initial value of this parameter upon game startup is 40. If the “respect” parameter of the PC falls to 0 or below,
the game ends with the PC in disgrace. If the “respect” rises above 80, the game ends with the PC in praise.

[Full Description](http://cs.oswego.edu/~alex/teaching/csc241/hw/project.pdf) 

To Run:

1: No input is needed to run.

2: The XML file needed to build the world is provided and called "world.xml". This will be prompted for when the program is run.
