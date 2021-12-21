CREATE TABLE round
(
    id             INT(11)       NOT NULL AUTO_INCREMENT,
    is_active      BOOLEAN       DEFAULT true,
    created_date   TIMESTAMP     NOT NULL DEFAULT now(),
    modified_date  TIMESTAMP     NOT NULL DEFAULT now(),
    PRIMARY KEY (id)
)