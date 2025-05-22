CREATE TABLE categories
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    title            VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE jt_instructor
(
    user_id BIGINT NOT NULL,
    subject VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (user_id)
);

CREATE TABLE jt_mentor
(
    user_id      BIGINT NOT NULL,
    company_name VARCHAR(255) NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_ta
(
    user_id       BIGINT NOT NULL,
    number_of_hrs INT    NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE msc_instructor
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    subject VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_msc_instructor PRIMARY KEY (id)
);

CREATE TABLE msc_mentor
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    CONSTRAINT pk_msc_mentor PRIMARY KEY (id)
);

CREATE TABLE msc_ta
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    number_of_hrs INT    NOT NULL,
    CONSTRAINT pk_msc_ta PRIMARY KEY (id)
);

CREATE TABLE products
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    created_at       datetime NULL,
    last_modified_at datetime NULL,
    title            VARCHAR(255) NULL,
    price DOUBLE NULL,
    `description`    VARCHAR(255) NULL,
    image            VARCHAR(255) NULL,
    category_id      BIGINT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE st_users
(
    id            BIGINT NOT NULL,
    user_type     INT NULL,
    name          VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    subject       VARCHAR(255) NULL,
    rating DOUBLE NULL,
    number_of_hrs INT    NOT NULL,
    company_name  VARCHAR(255) NULL,
    CONSTRAINT pk_st_users PRIMARY KEY (id)
);

CREATE TABLE tpc_instructors
(
    id      BIGINT NOT NULL,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    subject VARCHAR(255) NULL,
    rating DOUBLE NULL,
    CONSTRAINT pk_tpc_instructors PRIMARY KEY (id)
);

CREATE TABLE tpc_mentors
(
    id           BIGINT NOT NULL,
    name         VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    company_name VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_mentors PRIMARY KEY (id)
);

CREATE TABLE tpc_tas
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    number_of_hrs INT    NOT NULL,
    CONSTRAINT pk_tpc_tas PRIMARY KEY (id)
);

CREATE TABLE tpc_users
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_users PRIMARY KEY (id)
);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);