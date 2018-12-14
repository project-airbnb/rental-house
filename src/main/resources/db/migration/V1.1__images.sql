use airbnb;
create table images(
  id INT (255) Not NULL AUTO_INCREMENT PRIMARY KEY,
  name NVARCHAR(512),
  link NVARCHAR(512) NOT NULL,
  rent_id int (20),
  FOREIGN KEY (rent_id) REFERENCES rents(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
