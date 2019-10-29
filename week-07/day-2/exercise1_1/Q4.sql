/*
Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.
*/

/*
Q4: Some reviewers didn't provide a date with their rating.
	Find the names of all reviewers who have ratings with a NULL value for the date.
*/

/*
Expected Query Result:

Chris Jackson
Daniel Lewis

*/

SELECT DISTINCT name FROM reviewer as rev
JOIN rating as rat
ON rev.rID=rat.rID
WHERE rat.ratingDate IS NULL;
