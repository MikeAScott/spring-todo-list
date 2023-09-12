CREATE OR REPLACE DATABASE todo;
USE todo;

CREATE OR REPLACE USER todo@localhost IDENTIFIED BY 'todo';

GRANT ALL PRIVILEGES ON todo.* TO todo@localhost;

CREATE OR REPLACE TABLE todo
(
    id          UUID         NOT NULL DEFAULT UUID() PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    done        BOOLEAN      NOT NULL DEFAULT FALSE
);

INSERT INTO todo (title, description)
VALUES ('First todo', 'This is the first todo'),
       ('Second todo', 'This is the second todo'),
       ('Third todo', 'This is the third todo');
