create database TheaterManager;

use TheaterManager;

create table movie(
	movie_id int primary key,
	movie_name nvarchar(100),
	[description] nvarchar(255),
	onShowing bit,
	commingSoon bit
);
create table theater(
	theater_id int primary key,
	theater_name nvarchar(100),
	isUsing bit,
	theater_capacity int
);
create table [user](
	[user_id] int primary key,
	username nvarchar(50),
	[password] nvarchar(25),
	email nvarchar(100),
	fullName nvarchar(100),
	isAdmin bit
);
create table [period](
	period_id int primary key,
	period_date date,
	period_time time,
	period_size int,
	movie_id int,
	theater_id int,
	FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);
create table booking(
	booking_id int primary key,
	booking_amout int,
	period_id int,
	[user_id] int,
	FOREIGN KEY (period_id) REFERENCES [period](period_id),
	FOREIGN KEY ([user_id]) REFERENCES [user]([user_id]),
);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (0, 'admin', 'admin', 'admin@gmail.com', 'admin', 1);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (1, 'user1', 'user1',  'user1@gmail.com', 'user1 nguyen', 0);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (2, 'user2', 'user2',  'user2@gmail.com', 'user2 nguyen', 0);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (3, 'user3', 'user3',  'user3@gmail.com', 'user3 nguyen', 0);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (4, 'user4', 'user4',  'user4@gmail.com', 'user4 nguyen', 0);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (5, 'user5', 'user5',  'user5@gmail.com', 'user5 nguyen', 0);

INSERT INTO [user](user_id, username, [password], email, fullName, isAdmin)
VALUES (6, 'user6', 'user6',  'user6@gmail.com', 'user6 nguyen', 0);


INSERT INTO movie(movie_id, movie_name, [description], onShowing, commingSoon)
VALUES (1, 'movie 1', 'movie 1', 0, 1);

INSERT INTO movie(movie_id, movie_name, [description], onShowing, commingSoon)
VALUES (2, 'movie 2', 'movie 2', 0, 1);

INSERT INTO movie(movie_id, movie_name, [description], onShowing, commingSoon)
VALUES (3, 'movie 3', 'movie 3', 0, 1);

INSERT INTO movie(movie_id, movie_name, [description], onShowing, commingSoon)
VALUES (4, 'movie 4', 'movie 4', 0, 1);

INSERT INTO movie(movie_id, movie_name, [description], onShowing, commingSoon)
VALUES (5, 'movie 5', 'movie 5', 0, 1);

INSERT INTO theater(theater_id, theater_name, isUsing, theater_capacity)
VALUES (1, 'theater 1', 1, 10);

INSERT INTO theater(theater_id, theater_name, isUsing, theater_capacity)
VALUES (2, 'theater 2', 1, 10);

INSERT INTO theater(theater_id, theater_name, isUsing, theater_capacity)
VALUES (3, 'theater 3', 1, 5);

INSERT INTO theater(theater_id, theater_name, isUsing, theater_capacity)
VALUES (4, 'theater 4', 1, 5);

INSERT INTO theater(theater_id, theater_name, isUsing, theater_capacity)
VALUES (5, 'theater 5', 1, 10);

INSERT INTO [period](period_id, period_date, period_time, period_size, movie_id, theater_id)
VALUES (1, '2024-11-15',' 09:30:00', 0, null, null);

INSERT INTO [period](period_id, period_date,period_time, period_size, movie_id, theater_id)
VALUES (2, '2024-11-15',' 12:00:00', 0, null, null);

INSERT INTO [period](period_id, period_date,period_time, period_size, movie_id, theater_id)
VALUES (3, '2024-11-15',' 13:30:00', 0, null, null);

INSERT INTO [period](period_id, period_date,period_time, period_size, movie_id, theater_id)
VALUES (4, '2024-11-15',' 15:00:00', 0, null, null);

INSERT INTO [period](period_id, period_date,period_time, period_size, movie_id, theater_id)
VALUES (5, '2024-11-15',' 16:30:00', 0, null, null);

INSERT INTO [period](period_id, period_date,period_time, period_size, movie_id, theater_id)
VALUES (6, '2024-11-15',' 18:00:00', 0, null, null);


INSERT INTO booking(booking_id, booking_amout, period_id, [user_id])
VALUES (1, 2, 1, 1);

