CREATE TABLE game
(
    id                  INT(11)       NOT NULL AUTO_INCREMENT,
    round_id            INT(11)       DEFAULT NULL,
    winner_id           INT(11)       DEFAULT NULL,
    participant_one_id  INT(11)       DEFAULT NULL,
    participant_two_id  INT(11)       DEFAULT NULL,
    match_date          TIMESTAMP     NOT NULL DEFAULT now(),
    created_date        TIMESTAMP     NOT NULL DEFAULT now(),
    modified_date       TIMESTAMP     NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    CONSTRAINT roundMatchId FOREIGN KEY (round_id) REFERENCES round(id),
    CONSTRAINT winnerMatchId FOREIGN KEY (winner_id) REFERENCES participant(id),
    CONSTRAINT participantOneMatchId FOREIGN KEY (participant_one_id) REFERENCES participant(id),
    CONSTRAINT participantTwoMatchId FOREIGN KEY (participant_two_id) REFERENCES participant(id)
)