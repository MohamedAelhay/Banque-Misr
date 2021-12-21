CREATE TABLE participant
(
     id             INT(11)       NOT NULL AUTO_INCREMENT,
     name           VARCHAR(100)  NOT NULL,
     created_date   TIMESTAMP     NOT NULL DEFAULT now(),
     modified_date  TIMESTAMP     NOT NULL DEFAULT now(),
     PRIMARY KEY (id)
)