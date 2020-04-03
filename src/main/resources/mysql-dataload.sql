DROP TABLE IF EXISTS services;
CREATE TABLE services (
                          requestNumber INTEGER NOT NULL auto_increment,
                          customerName VARCHAR(20) NOT NULL,
                          customerAddress VARCHAR(50) NOT NULL,
                          technician VARCHAR(20),
                          phoneNumber VARCHAR(20) NOT NULL,
                          descr VARCHAR(200) NOT NULL,
                          PRIMARY KEY (requestNumber)
);

INSERT INTO services(requestNumber, customerName, customerAddress, technician, phoneNumber, descr) VALUES (1, "Al Simmons", "1234 New York Ave. New York, NY 10033", NULL, "5555555555", "My washer is broken please come fix");
INSERT INTO services(requestNumber, customerName, customerAddress, technician, phoneNumber, descr) VALUES (2, "Wanda Blake", "334 Westchester Rd. New York, NY 10103", NULL, "1234567890", "Tv is broken, please come fix");
