/*

Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.

/*


/*
Q1: Find the names of all reviewers who rated Gone with the Wind.
*/

/*
Expected Query Result:
Mike Anderson
Sarah Martinez
*/

SELECT DISTINCT name
    FROM Reviewer AS rev
    LEFT JOIN rating AS rat
    ON rev.rID = rat.rID
    JOIN movie as m
    ON rat.mID = m.mID
    WHERE m.title = "Gone with the Wind"