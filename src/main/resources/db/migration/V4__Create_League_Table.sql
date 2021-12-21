CREATE TABLE league
(
    id                  INT(11)       NOT NULL AUTO_INCREMENT,
    champion            INT(11)       DEFAULT NULL,
    created_date        TIMESTAMP     NOT NULL DEFAULT now(),
    modified_date       TIMESTAMP     NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    CONSTRAINT leagueChampion FOREIGN KEY (champion) REFERENCES participant(id)
)