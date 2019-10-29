/*

Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.

/*


/*
Q2: For any rating where the reviewer is the same as the director of the movie,
	return the reviewer name, movie title, and number of stars.
*/

/*
Expected Query Result:
James Cameron	Avatar	5
*/

SELECT rev.name, m.title, rat.stars
    FROM reviewer as rev
    JOIN rating as rat
		ON rev.rID = rat.rID
    JOIN movie as m
		ON rat.mID = m.mID
    WHERE rev.name = m.director