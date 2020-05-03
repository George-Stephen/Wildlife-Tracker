# Wildlife-Tracker
## Author 
George Stephen Wangui yazz777stevie@gmail.com
## Description
This is an application meant to assist park rangers of the St Douglas Fir to record their own sightings that they find in the forests
It has three entry forms and three display forms excluding the home page and success page.It has  a background of the african savannah and
the wildlife within it
## Development
This project was built using languages such as Java/Spark,HTML,CSS.it has utilised the use of PostgreSql to serve a database 
and Handlebars to help build and route between the User interface.
## Setup
To create the necessary databases, launch postgres, then psql, and run the following commands:

CREATE DATABASE wildlife_tracker;
\c wildlife_tracker;
CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
CREATE TABLE endangered (id serial PRIMARY KEY ,name varchar,age varchar,health varchar);
CREATE  TABLE  sightings (id serial PRIMARY KEY ,ranger varchar,date timestamp);
CREATE TABLE rangers ( id serial PRIMARY KEY ,name varchar , phone varchar,email varchar);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
## License
MIT  license 2020
