CREATE TABLE user (
  email VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  user_id INT,
  enabled boolean NOT NULL,
  PRIMARY KEY (email)
);
   
CREATE TABLE authorities (
  email VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES user(email)
);
CREATE UNIQUE INDEX ix_auth_username on authorities (email,authority);

CREATE TABLE event (
  id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(100) NOT NULL,
  date DATE ,
  PRIMARY KEY (id)
);

CREATE TABLE special_event (
  id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(100) NOT NULL,
  date DATE ,
  PRIMARY KEY (id)
);

  