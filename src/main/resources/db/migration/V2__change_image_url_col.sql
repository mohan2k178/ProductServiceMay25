ALTER TABLE products
    ADD image_url VARCHAR(255) NULL;

ALTER TABLE products
DROP
COLUMN image;

ALTER TABLE st_users
    MODIFY number_of_hrs INT NOT NULL;

ALTER TABLE st_users
    MODIFY user_type INT NULL;