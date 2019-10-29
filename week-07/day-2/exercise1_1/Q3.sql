/*
Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.
*/

/*
Q3: Find the titles of all movies that have no ratings.
*/

/*
Expected Query Result:

Star Wars
Titanic

*/

SELECT DISTINCT title FROM movie AS m
    LEFT JOIN rating
    ON m.mID=rating.mID
    WHERE stars IS NULL;
