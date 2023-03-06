Create Table USER (
                      id int PRIMARY KEY,
                      name varchar(100) NOT NULL,
                      email varchar(100) NOT NULL,
                      password varchar(100) NOT NULL,
                      sex varchar(6) NOT NULL,
                      age int
);

Create Table POSTS (
                       id int PRIMARY KEY,
                       title varchar(100) NOT NULL,
                       comment varchar NOT NULL,
                       createdDate Date,
                       userId int,
                       CONSTRAINT fk_user FOREIGN KEY(userId)
                           REFERENCES USERS(id)
);

Create Table COMMENTS (
                          id int PRIMARY KEY,
                          comment varchar NOT NULL,
                          createdDate Date,
                          postId int,
                          CONSTRAINT fk_post FOREIGN KEY(postId)
                              REFERENCES POSTS(id)
);

Create Table LIKES (
                       id int PRIMARY KEY,
                       postId int,
                       commentId int,
                       CONSTRAINT fk_post_like FOREIGN KEY(postId)
                           REFERENCES POSTS(id),
                       CONSTRAINT fk_comment_like FOREIGN KEY(commentId)
                           REFERENCES COMMENTS(id)
);

INSERT INTO USERS(id, name, email, password, sex, age)
VALUES (1, 'Bohdan', 'myemail@my.com', '1111', 'MALE', 25)
    (2, 'Vadym', 'vadymmy.com', '2222', 'MALE', 24),
    (3, 'Ostap', 'ostapmy.com', '3333', 'MALE', 33),
    (4, 'Hanna', 'hannamy.com', '4444', 'FEMALE', 28),
    (5, 'Natali', 'natalimy.com', '555', 'FEMALE', 24);

INSERT INTO POSTS(id, title, comment, createdDate, userId)
VALUES (1, 'Title', 'Comment', NULL, 1),
       (2, 'Test', 'Test comment', NULL, 1),
       (3, 'Title', 'Comment', NULL, 2),
       (4, 'wasd', 'wasd', NULL, 2),
       (5, '1234567890', '0987654321', NULL, 2),
       (6, '1234', '4321', NULL, 4),
       (7, 'Hanna', 'Hanna', NULL, 4);

INSERT INTO COMMENTS(id, comment, createdDate, postId)
VALUES (1, 'Comment', NULL, 9);