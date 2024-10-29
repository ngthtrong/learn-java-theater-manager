create database TheaterManager;

use TheaterManager;

create table movie(
	movie_id int primary key,
	movie_name nvarchar(100),
	[description] nvarchar(255),
	onShowing bit,
	commingSoon bit
) create table theater(
	theater_id int primary key,
	theater_name nvarchar(100),
	isUsing bit,
	theater_capacity int
) create table [user](
	[user_id] int primary key,
	username nvarchar(50),
	[password] nvarchar(25),
	email nvarchar(100),
	fullName nvarchar(100),
	isAdmin bit
) create table [period](
	period_id int primary key,
	period_time smalldatetime,
	period_size int,
	movie_id int,
	theater_id int,
	FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
) create table booking(
	booking_id int primary key,
	booking_amout int,
	period_id int,
	[user_id] int,
	FOREIGN KEY (period_id) REFERENCES [period](period_id),
	FOREIGN KEY ([user_id]) REFERENCES [user]([user_id]),
)