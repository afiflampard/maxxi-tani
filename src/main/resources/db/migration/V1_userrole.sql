CREATE TABLE roles(
   id INT GENERATED ALWAYS AS IDENTITY,
   name VARCHAR(255) NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE users(
   id INT GENERATED ALWAYS AS IDENTITY,
   password VARCHAR(255) NOT NULL,
   nama VARCHAR(32),
   email VARCHAR(255),
   username VARCHAR(255) UNIQUE,
   code VARCHAR(32),
   alamat VARCHAR(255),
   no_ktp VARCHAR(32),
   no_telp VARCHAR(32),
   PRIMARY KEY(id)
);

INSERT INTO roles(name) VALUES ("Admin"), ("Petani");
CREATE TABLE user_roles(
   user_id INT,
   role_id INT,
   CONSTRAINT fk_users
      FOREIGN KEY(user_id) 
	  REFERENCES users(id),
   CONSTRAINT fk_roles
      FOREIGN KEY(role_id) 
	  REFERENCES roles(id)
);

