The project compares the brute force algorithm for finding the two closest points from a given set of points to the divide and 
conquer approach for finding the two closest points in a given set of points.

There are two ways this program takes the input. If there is no command line argument the application prompts the console to read the points 
in following way. Every line should contains two double point numbers and end of the input should be marked with "end" string.

The following reads ten points and gives the result 

2 3 
4 5 
9 8 
8 7 
11 23
89 1
90 20
-1 80
-1 4 
0 4
end

 Brute Force Results : 
Closest points are (-1.0,4.0) and (0.0,4.0) 1.0 units apart
Total time : 0
 Divide and Conquer Results : 
Closest points are (-1.0,4.0) and (0.0,4.0) 1.0 units apart
Total time : 5


Now if we want to go for random generation of data, We have to add the command line argument and run the program as follow :
java ClosestPointDriver r

The program prompts the console in following way:

 How many random points ? 
2000

 Brute Force Results : 
Closest points are (1704.0,4297.0) and (1707.0,4295.0) 3.605551275463989 units apart
Total time : 61
 Divide and Conquer Results : 
Closest points are (1704.0,4297.0) and (1707.0,4295.0) 3.605551275463989 units apart
Total time : 39

How many random points ? 
5000
 Brute Force Results : 
Closest points are (1746.0,6363.0) and (1746.0,6365.0) 2.0 units apart
Total time : 352
 Divide and Conquer Results : 
Closest points are (1746.0,6363.0) and (1746.0,6365.0) 2.0 units apart
Total time : 179


 How many random points ? 
100000
 Brute Force Results : 
Closest points are (6275.0,6629.0) and (6275.0,6629.0) 0.0 units apart
Total time : 51659
 Divide and Conquer Results : 
Closest points are (6275.0,6629.0) and (6275.0,6629.0) 0.0 units apart
Total time : 19123






By increasing the number of points we can see the advantage of using O(n logn) divide and conquer algorithm over the brute force O(n^2) algorithm



