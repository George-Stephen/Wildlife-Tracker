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
MIT License

Copyright (c) [2020] [George Stephen Wangui ] Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
