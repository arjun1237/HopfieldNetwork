# HopfieldNetwork
Neural Network project


Hopfield networks
For this assessment, you are asked to write a simulation of a Hopfield neural network using Hebbian learning as discussed in the lectures. This program must be written in Java and must be executable on raptor from the command line. Your computer program must have the following behaviour:
-The program accepts two text files:
(I)A file that specifies complete patterns to be learned.
(II)A file that specifies a number of corrupted patterns, corresponding to (I).
I will call the program using the following commands with command line switches:
java hopf pathtocomplepattern pathtoincomplete
Here “pathtocompletepattern” will be replaced by a path to the file containing the complete patterns to be learned/stored; similarly with “pathtoincomplete” which will be replaced by the path to a file containing the incomplete/corrupted patterns. So, for example, I will call the progamme using
java hopf ~/storedpatterns.txt ~/incompletepatterns.txt
or
java hopf ~/stp.dat ~/inc.dat
or something similar. The program must be executable from the command line in the relevant folder on raptor, that is you cannot use BlueJ. Before you submit your final version, make sure you test your program on raptor.
-The program should then output to standard out (i.e. the command line) a list of patterns corresponding to the input corrupted input pattern.
-The number of output patterns should be equal to the number of corrupted patterns that were supplied in the file.
-If the input given is not feasible, for example because it cannot be learned, then the program should exit straight away outputting 0.
An example:
The complete patterns could be:
1 1 1 1 -1
The partial pattern could be
-1 1 1 1 -1
-The output of the program should be the reconstituted pattern corresponding to the list of corrupted input patterns. One pattern per line. So, if the list of corrupted input patterns contains 5 lines, then the output should also be 5 lines. In the above example this would be a single line output:
