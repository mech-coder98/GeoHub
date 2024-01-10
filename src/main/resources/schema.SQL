CREATE TABLE if not exists COUNTRY (
    countryId INT PRIMARY KEY AUTO_INCREMENT,
    countryName VARCHAR (300),
    currency VARCHAR (300),
    population INT,
    latitude VARCHAR (300),
    longitude VARCHAR (300)
);

CREATE TABLE if not exists CITY (
    cityId INT PRIMARY KEY AUTO_INCREMENT,
    cityName VARCHAR (300),
    population INT,
    latitude VARCHAR (300),
    longitude VARCHAR (300),
    countryId INT,

    FOREIGN KEY (countryId) REFERENCES COUNTRY(countryId)
);