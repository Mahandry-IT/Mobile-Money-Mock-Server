CREATE TABLE token(
    idtoken INT AUTO_INCREMENT,
    access_token TEXT NOT NULL,
    expires_at DATETIME NOT NULL,
    token_type VARCHAR(255)  NOT NULL,
    PRIMARY KEY(idtoken)
);