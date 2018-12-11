use airbnb;
create table categories (
                          id int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                          name NVARCHAR(255) NOT NULL
);
create table rents(
                    id int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                    title NVARCHAR(255) NOT NULL ,
                    content TEXT NOT NULL ,
                    status boolean,
                    datetime datetime,
                    user_id int(20),
                    category_id int(20),
                    FOREIGN KEY (user_id) REFERENCES users(id),
                    FOREIGN KEY (category_id) REFERENCES categories(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
