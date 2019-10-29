/*
Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.
*/

/*
Q2: Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.
*/

/*
Expected Query Result:

1937
1939
1981
2009

*/


SELECT DISTINCT year FROM movie AS m
    JOIN rating
    ON m.mID = rating.mID
    WHERE rating.stars=4
        OR rating.stars=5
    ORDER BY year ASC;
