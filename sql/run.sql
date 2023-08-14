Create Table USERS (
                      id bigint PRIMARY KEY,
                      name varchar(100) NOT NULL,
                      email varchar(100) NOT NULL,
                      password varchar(100) NOT NULL,
                      sex varchar(6) NOT NULL,
                      age int
);

Create Table POSTS (
                       id bigint PRIMARY KEY,
                       title varchar(100) NOT NULL,
                       comment text NOT NULL,
                       createdDate Date,
                       user_id int,
                       CONSTRAINT fk_user FOREIGN KEY(user_id)
                           REFERENCES USERS(id)
);

Create Table COMMENTS (
                          id bigint PRIMARY KEY,
                          comment varchar NOT NULL,
                          createdDate Date,
                          post_id int,
                          CONSTRAINT fk_post FOREIGN KEY(post_id)
                              REFERENCES POSTS(id)
);

Create Table LIKES (
                       id bigint PRIMARY KEY,
                       post_id int,
                       comment_id int,
                       CONSTRAINT fk_post_like FOREIGN KEY(post_id)
                           REFERENCES POSTS(id),
                       CONSTRAINT fk_comment_like FOREIGN KEY(comment_id)
                           REFERENCES COMMENTS(id)
);

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