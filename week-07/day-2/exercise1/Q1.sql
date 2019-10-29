/*
Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.
*/

/*
Q1: Find the names of all reviewers who rated Gone with the Wind.
*/

/*
Expected Query Result:

E.T.
Raiders of the Lost Ark

*/

SELECT title FROM movie
    WHERE director = "Steven Spielberg";
    