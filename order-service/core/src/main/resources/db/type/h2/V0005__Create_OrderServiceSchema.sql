-- *** BinaryObject (BLOBs) ***
CREATE TABLE Item (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name                VARCHAR(255) NOT NULL,
  description         VARCHAR(255),
  price               DOUBLE NOT NULL,
  PRIMARY KEY (ID),
  CONSTRAINT UC_Item_name UNIQUE(name)
);
CREATE TABLE Customer (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  firstname           VARCHAR(255) NOT NULL,
  lastname			  VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
);
CREATE TABLE OrderSummary (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  price               DOUBLE NOT NULL,
  ownerId             BIGINT NOT NULL,
  creationDate		  DATE NOT NULL,
  status          	  VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID),
  FOREIGN KEY (ownerId) REFERENCES Customer(id)
);
CREATE TABLE OrderPosition  (
  orderId             BIGINT NOT NULL AUTO_INCREMENT,
  itemId              BIGINT NOT NULL AUTO_INCREMENT,
  FOREIGN KEY (orderId) REFERENCES OrderSummary(id),
  FOREIGN KEY (itemId) REFERENCES Item(id)
);

