------ Digital Library Audit ---------

-- 1. Student Table 

create table Student(
  studentId int primary key,
  studentName varchar(20) not null,
  email varchar(50) not null,
  lastBorrowDate date
  );


-- 2. Books table 
create table Books (
  bookId int primary key,
  title varchar(100) not null,
  category varchar(100) 
  );
  

  -- 3 issued books table
create table IssuedBooks(
  issueID Integer primary key,
  bookId int,
  studentId int,
  issueDate date,
  returnDate date null,
  foreign key(bookId) references Books(bookId),
  foreign key ( studentId) references student(studentId)
);


-- Data Insertion
-- students table

insert into Student (studentId, studentName , email, lastBorrowDate) values 
(101, 'Nani', 'nani@gmail.com', '2026-04-01'),
(102, 'Priya', 'priya@gmail.com', '2021-01-10'),
(103, 'Srinivas', 'srinu@gmail.com', '2026-01-02'),
(104, 'Mouli' , 'mouli123@gmail.com' , '2026-04-22'),
(105,'Abdul','abdul143@gmail.com','2026-03-21');

-- Books Table
insert into Books (bookId, Title, Category) values 
(501, 'Deep Learning', 'Science'),
(502, 'Modern History', 'History'),
(503, 'Python Basics', 'Science'),
(504, 'Material Sciences', 'Civil'),
(505, 'Fluid Mechanics', 'Mechanical'),
(506, 'Electrical Systems', 'EEE');


-- Issued Books Table
insert into IssuedBooks (bookId, studentId, issueDate, returnDate) 
VALUES 
(501, 101, '2026-04-01', NULL),       -- OVERDUE
(502, 103, '2026-04-05', NULL),       -- OVERDUE
(503, 104, '2026-04-20', NULL),       -- ON TIME
(504, 105, '2026-04-10', '2026-04-15'), -- RETURNED
(506, 101, '2026-04-22', NULL);       -- ON TIME


-- Analytics

-- 1. Overdue Report
SELECT s.studentName, b.title, i.issueDate 
FROM IssuedBooks i
JOIN Student s ON i.studentId = s.studentId
JOIN Books b ON i.bookId = b.bookId
WHERE i.returnDate IS NULL 
AND julianday('now') - julianday(i.issueDate) > 14;

-- Popularity
SELECT b.Category, COUNT(i.issueID) AS TimesBorrowed
FROM Books b
JOIN IssuedBooks i ON b.bookId = i.bookId
GROUP BY b.Category
ORDER BY TimesBorrowed DESC;

-- Deleting InActive Users
DELETE FROM Student 
WHERE julianday('now') - julianday(lastBorrowDate) > (3 * 365);


