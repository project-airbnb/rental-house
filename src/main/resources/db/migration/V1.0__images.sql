use airbnb;
create table images(
  id INT (255) Not NULL AUTO_INCREMENT PRIMARY KEY,
  alt NVARCHAR(512),
  link NVARCHAR(512) NOT NULL
);
create table image_rent(
  image_id(25) NOT NULL ,
  rent_id(20) NOT NULL ,
  PRIMARY KEY (image_id, rent_id),
  ENGINE=InnoDB DEFAULT CHARSET=utf8
);
