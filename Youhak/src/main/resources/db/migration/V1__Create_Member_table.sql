CREATE TABLE member
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    email     VARCHAR(255) NOT NULL,
    nickname  VARCHAR(255) NOT NULL,
    name      VARCHAR(255) NOT NULL,
    gender    INT          NOT NULL,
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    is_deleted BOOLEAN      NOT NULL
);

CREATE TABLE role_category
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(255) NOT NULL,
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    is_deleted BOOLEAN      NOT NULL
);

CREATE TABLE role
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    category_id BIGINT,
    created_at   DATETIME     NOT NULL,
    updated_at   DATETIME     NOT NULL,
    is_deleted   BOOLEAN      NOT NULL,
    FOREIGN KEY (category_id) REFERENCES role_category (id)
);

CREATE TABLE member_role
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_id BIGINT,
    role_id   BIGINT,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    is_deleted BOOLEAN  NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE login
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_id BIGINT,
    account   VARCHAR(255) NOT NULL UNIQUE,
    password  VARCHAR(255) NOT NULL,
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    is_deleted BOOLEAN      NOT NULL,
    FOREIGN KEY (member_id) REFERENCES member (id)
);
