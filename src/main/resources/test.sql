INSERT INTO USERS(id, name, email, password, sex, age)
VALUES (1, 'Bohdan', 'myemail@my.com', '1111', 'MALE', 25),
       (2, 'Vadym', 'vadymmy@.com', '2222', 'MALE', 24),
       (3, 'Ostap', 'ostapmy@.com', '3333', 'MALE', 33),
       (4, 'Hanna', 'hannamy@.com', '4444', 'FEMALE', 28),
       (5, 'Natali', 'natalimy@.com', '555', 'FEMALE', 24);

INSERT INTO POSTS(id, title, comment, createdDate, user_id)
VALUES (1, 'Title', 'Comment', NULL, 1),
       (2, 'Test', 'Test comment', NULL, 1),
       (3, 'Title', 'Comment', NULL, 2),
       (4, 'wasd', 'wasd', NULL, 2),
       (5, '1234567890', '0987654321', NULL, 2),
       (6, '1234', '4321', NULL, 4),
       (7, 'Hanna', 'Hanna', NULL, 4);

INSERT INTO COMMENTS(id, comment, createdDate, post_id)
VALUES (1, 'Comment', NULL, 9);