# PalavraPuxaPalavra

In this program we will resolve a charade. This game consist in only changing one letter per word, obtaining another word that exists in a given dictionary with the hortest path. And with that go from a initial word to a destination word with the fastest way.
Example: From the word pool reach the word rule, so the path will be for example pool->poll->pole->role->rule.
When there is no sequence in this dictionary that can resolve the charade the output will be "sequencia inexistente".

To execute this program you will need a java compiler. And then the inout will consiste in the first line you put the
 N number of words that will make your dictionary to resolve this charade, then the N words of the dictionary, after
 that you will put the K number of charades you want to resolve in this execution, and then the K initial and final
 words.
 
 Input Example:
7
pool
pole
rule
roll
role
poll
mens
2
pool rule
pole mens

Output:
pool->rule: 5 pool poll pole role rule
pole->mens: sequencia inexistente

The program will give the shortest path for that word, because you could go pool->poll->pole->roll->role->rule, but the program gives the shortest path using the algorithm BFS.
