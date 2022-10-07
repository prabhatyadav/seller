create database e_action;
use  e_action;

CREATE TABLE person (
    id BIGINT NOT NULL AUTO_INCREMENT,
    address VARCHAR(255),
    city VARCHAR(255),
    email VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    person_type INTEGER,
    phone VARCHAR(255),
    pin VARCHAR(255),
    state VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;

alter table person add unique person_unique_email_phone_person_type(email,phone,person_type);

CREATE TABLE product (
    id BIGINT NOT NULL AUTO_INCREMENT,
    bid_end_date DATETIME,
    bid_start_date DATETIME,
    created_date DATETIME,
    detailed_description VARCHAR(255),
    is_deleted BIT,
    name VARCHAR(255),
    short_description VARCHAR(255),
    starting_price DOUBLE PRECISION,
    category_id BIGINT,
    seller_id BIGINT,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE product_category (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
)  ENGINE=INNODB;

 alter table product add constraint FK5cypb0k23bovo3rn1a5jqs6j4 foreign key (category_id) references product_category (id);
 alter table product add constraint FKjjapuxatfhwgjulb837kvhkoy foreign key (seller_id) references person (id);

