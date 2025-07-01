CREATE TABLE token(
   idtoken INT AUTO_INCREMENT,
   access_token TEXT NOT NULL,
   expires_at DATETIME NOT NULL,
   token_type VARCHAR(255)  NOT NULL,
   provider_code VARCHAR(255)  NOT NULL,
   PRIMARY KEY(idtoken)
);

CREATE TABLE Transaction(
   idtransaction VARCHAR(255) ,
   provider_code VARCHAR(255)  NOT NULL,
   amount DECIMAL(15,2)   NOT NULL,
   currency VARCHAR(4)  NOT NULL,
   phone_number VARCHAR(255)  NOT NULL,
   PRIMARY KEY(idtransaction)
);

CREATE TABLE Response(
   idresponse INT AUTO_INCREMENT,
   phone_number VARCHAR(255)  NOT NULL,
   messsage VARCHAR(255)  NOT NULL,
   description TEXT NOT NULL,
   provider_code VARCHAR(255)  NOT NULL,
   PRIMARY KEY(idresponse)
);
