/*
Movie ( mID, title, year, director )
English: There is a movie with ID number mID, a title, a release year, and a director.

Reviewer ( rID, name )
English: The reviewer with ID number rID has a certain name.

Rating ( rID, mID, stars, ratingDate )
English: The reviewer rID gave the movie mID a number of stars rating (1-5) on a certain ratingDate.
*/

/*
Q5: Write a query to return the ratings data in a more readable format:
		reviewer name, movie title, stars, and ratingDate.
    Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars.
*/

/*
Expected Query Result:

Ashley White						E.T.	3	2011-01-02
Brittany Harris		Raiders of the Lost Ark	2	2011-01-30
Brittany Harris		Raiders of the Lost Ark	4	2011-01-12
Brittany Harris			The Sound of Music	2	2011-01-20
Chris Jackson						E.T.	2	2011-01-22
Chris Jackson		Raiders of the Lost Ark	4		<NULL>
Chris Jackson			The Sound of Music	3	2011-01-27
Daniel Lewis					Snow White	4		<NULL>
Elizabeth Thomas					Avatar	3	2011-01-15
Elizabeth Thomas				Snow White	5	2011-01-19
James Cameron						Avatar	5	2011-01-20
Mike Anderson			Gone with the Wind	3	2011-01-09
Sarah Martinez			Gone with the Wind	2	2011-01-22
Sarah Martinez			Gone with the Wind	4	2011-01-27

*/

SELECT rev.name, m.title, rat.stars, rat.ratingDate
    FROM reviewer AS rev
    LEFT JOIN rating AS rat
        ON rat.rID=rev.rID
    LEFT JOIN movie AS m
        ON rat.mID=m.mID
ORDER BY rev.name, m.title, rat.stars;
