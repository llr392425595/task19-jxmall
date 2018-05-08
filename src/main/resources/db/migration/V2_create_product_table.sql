CREATE TABLE product(
  id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(100),
  description varchar(500),
  price int(10),
  inventoryId int(10) DEFAULT NULL,
  FOREIGN KEY (inventoryId) REFERENCES inventory(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;