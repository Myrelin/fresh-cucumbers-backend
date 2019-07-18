# fresh-cucumbers-backend

A teamwork study project for the CodeCool organization, this project was used to understand the basics of Spring Boot, 
JPA and Hibernate usage.


We developed a website where visitors can search for movies by title, and see reviews for that searched movie.
Visitors can also add reviews of their own, which will be saved in the database.

This is only the backend repository! Please also clone the frontend repository, which you can find here:
https://github.com/thaoPhLam/fresh-cucumbers-frontend

To avoid duplicate entries in the database, every search string will be queried from the database. The external APIs will 
only be queried if there is no database entry with the searched movie title.

On the landing page, you will also find a selection of top rated movies according to IMDB ratings (and the developer's own choices).

Requirements: 

To try or test this project, several environmental variables will need to be set. 

1.) You will need to register with www.omdbapi.com to get access to an apikey. 
2.) You will need to register with www.themoviedb.org to get access to an apikey.
3.) Create a database, and add the name, username and password access.

Environmental variables: 

DB_USERNAME: *
DB_PASSWORD:
TMDB_APIKEY You receive this after registering on the site
TMDB_APIURL: https://api.themoviedb.org/3/ (base URL)
OMDB_APIKEY: You receive this after registering on the site
OMDB_APIURL: http://www.omdbapi.com/ (base URL)

* A note on psql. If you are using the default user (postgres) after installation, there is no default password.
It is highly recommended that you set one. 

