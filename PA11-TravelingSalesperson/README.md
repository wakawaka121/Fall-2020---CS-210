Results for: big11.mtx TIME.

test1
heuristic: cost = 3.3969307170000005, 0 milliseconds
mine: cost = 1.3566775349999998, 15 milliseconds
backtrack: cost = 1.3566775349999998, 12 milliseconds

test2
heuristic: cost = 3.3969307170000005, 0 milliseconds
mine: cost = 1.3566775349999998, 7 milliseconds
backtrack: cost = 1.3566775349999998, 8 milliseconds

test3
heuristic: cost = 3.3969307170000005, 0 milliseconds
mine: cost = 1.3566775349999998, 6 milliseconds
backtrack: cost = 1.3566775349999998, 5 milliseconds

test4
heuristic: cost = 3.3969307170000005, 0 milliseconds
mine: cost = 1.3566775349999998, 6 milliseconds
backtrack: cost = 1.3566775349999998, 7 milliseconds

test5
heuristic: cost = 3.3969307170000005, 0 milliseconds
mine: cost = 1.3566775349999998, 7 milliseconds
backtrack: cost = 1.3566775349999998, 6 milliseconds


The MINE improves on the backtracking method. The improved method peforms an additional check after a node is added to path so far to see if the path so far is getting 
with in 30% of the minPath, Meaning that the distance to the next node will not be a optimal choice, and should be bandonded. The 5 tests shown
show that on ocassion (test 2 and test 4) there is an improvement. While the other test cases show similar time expenditures. This show that the impoved
backtracking method does improve the inital backtracking method implemented. The times seem to vary based on the system load.