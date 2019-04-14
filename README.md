# PalavraPuxaPalavra English

In this program we will resolve a charade. This game consist in only changing one letter per word, obtaining another word that exists in a given dictionary with the hortest path. And with that go from a initial word to a destination word with the fastest way.</br>
Example: From the word pool reach the word rule, so the path will be for example pool->poll->pole->role->rule.</br>
When there is no sequence in this dictionary that can resolve the charade the output will be "sequencia inexistente".</br>

To execute this program you will need a java compiler. And then the inout will consiste in the first line you put the
 N number of words that will make your dictionary to resolve this charade, then the N words of the dictionary, after
 that you will put the K number of charades you want to resolve in this execution, and then the K initial and final
 words.</br>
 
 Input Example:</br>
7</br>
pool</br>
pole</br>
rule</br>
roll</br>
role</br>
poll</br>
mens</br>
2</br>
pool rule</br>
pole mens</br>

Output:</br>
pool->rule: 5 pool poll pole role rule</br>
pole->mens: sequencia inexistente

The program will give the shortest path for that word, because you could go pool->poll->pole->roll->role->rule, but the program gives the shortest path using the algorithm BFS.</br>

# PalavraPuxaPalavra Portuguese
