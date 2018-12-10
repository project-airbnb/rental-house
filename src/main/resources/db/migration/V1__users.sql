create table users(
  id int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  username NVARCHAR(255) NOT NULL ,
  password NVARCHAR(255) NOT NULL ,
  email NVARCHAR(512) NOT NULL ,
  province NVARCHAR(255),
  address NVARCHAR(999),
  phone NVARCHAR(13),
  gender NVARCHAR(5),
  level_type int (5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
