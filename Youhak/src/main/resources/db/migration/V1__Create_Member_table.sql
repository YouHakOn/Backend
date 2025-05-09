CREATE TABLE Member
(
    id        BIGINT PRIMARY KEY,
    email     VARCHAR(255) NOT NULL,
    nickname  VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL,
    gender    INT          NOT NULL,
    createdAt DATETIME     NOT NULL,
    updatedAt DATETIME     NOT NULL,
    isDeleted BOOLEAN      NOT NULL
);

CREATE TABLE Role_Category
(
    id        BIGINT PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    createdAt DATETIME     NOT NULL,
    updatedAt DATETIME     NOT NULL,
    isDeleted BOOLEAN      NOT NULL
);

CREATE TABLE Role
(
    id          BIGINT PRIMARY KEY,
    category_id BIGINT,
    createdAt   DATETIME NOT NULL,
    updatedAt   DATETIME NOT NULL,
    isDeleted   BOOLEAN  NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Role_Category (id)
);

CREATE TABLE Member_Role
(
    id        BIGINT PRIMARY KEY,
    member_id BIGINT,
    role_id   BIGINT,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    isDeleted BOOLEAN  NOT NULL,
    FOREIGN KEY (member_id) REFERENCES Member (id),
    FOREIGN KEY (role_id) REFERENCES Role (id)
);

CREATE TABLE Login
(
    id        BIGINT PRIMARY KEY,
    member_id BIGINT,
    account   VARCHAR(255) NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    createdAt DATETIME     NOT NULL,
    updatedAt DATETIME     NOT NULL,
    isDeleted BOOLEAN      NOT NULL,
    FOREIGN KEY (member_id) REFERENCES Member (id)
);
