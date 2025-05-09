CREATE TABLE Member
(
    id         BIGINT PRIMARY KEY,
    email      VARCHAR(255)                     NOT NULL,
    nickname   VARCHAR(255)                     NOT NULL,
    name       VARCHAR(255)                     NOT NULL,
    gender     ENUM ('MALE', 'FEMALE', 'OTHER') NOT NULL,
    createdAt  DATETIME                         NOT NULL,
    modifiedAt DATETIME                         NOT NULL
);

CREATE TABLE Role_Category
(
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Role
(
    id          BIGINT PRIMARY KEY,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES Role_Category (id)
);

CREATE TABLE Member_Role
(
    member_id BIGINT,
    role_id   BIGINT,
    PRIMARY KEY (member_id, role_id),
    FOREIGN KEY (member_id) REFERENCES Member (id),
    FOREIGN KEY (role_id) REFERENCES Role (id)
);

CREATE TABLE Login
(
    id        BIGINT PRIMARY KEY,
    member_id BIGINT,
    FOREIGN KEY (member_id) REFERENCES Member (id)
);
