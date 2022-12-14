CREATE TABLE ARTIST(
  ARTIST_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(36) NOT NULL,
  COUNTRY CHAR(2),
  BIO VARCHAR(256)
);

CREATE TABLE ALBUM(
  ALBUM_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  TITLE VARCHAR(64),
  ARTIST_ID BIGINT NOT NULL,
  YEAR INT,
  INFO VARCHAR(1000)
);

CREATE TABLE FORMAT(
  FORMAT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  ALBUM_ID BIGINT NOT NULL,
  RELEASE_DATE DATE,
  FORMAT VARCHAR (5),
  NOTES VARCHAR (20),
  LABEL VARCHAR(64),
  PRICE INT,
  IMG VARCHAR(100)
);

CREATE TABLE ORDERZ(
    ORDER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CLIENT_ID BIGINT NOT NULL
);

CREATE TABLE ORDER_ITEMS(
    ORDER_ID BIGINT,
    FORMAT_ID BIGINT,
    QUANTITY INT,
    PRIMARY KEY(ORDER_ID, FORMAT_ID)
);

CREATE TABLE CLIENT(
    CLIENT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(20),
    LAST_NAME VARCHAR(20),
    ADDRESS VARCHAR(100)
);

ALTER TABLE FORMAT ADD FOREIGN KEY (ALBUM_ID) REFERENCES ALBUM(ALBUM_ID);
ALTER TABLE ALBUM ADD FOREIGN KEY (ARTIST_ID) REFERENCES ARTIST(ARTIST_ID);
ALTER TABLE ORDER_ITEMS ADD FOREIGN KEY (ORDER_ID) REFERENCES ORDERZ(ORDER_ID);
ALTER TABLE ORDER_ITEMS ADD FOREIGN KEY (FORMAT_ID) REFERENCES FORMAT(FORMAT_ID);
ALTER TABLE ORDERZ ADD FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(CLIENT_ID);