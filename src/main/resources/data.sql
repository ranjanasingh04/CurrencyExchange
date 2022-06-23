create table 
Calculated_History(ID IDENTITY NOT NULL primary key, 
valueToBeCalculated number not null,sourceCurrency varchar(10), 
destinationCurrency varchar(10),creationDate date,calculated_value number);

insert into Calculated_History values(1,100,'USD','EUR',now(),190.90);
insert into Calculated_History values(2,100,'USD','EUR',now(),100);
insert into Calculated_History values(3,100,'USD','EUR',now(),100);
insert into Calculated_History values(4,100,'USD','EUR',now(),100);
insert into Calculated_History values(5,100,'USD','EUR',now(),100);
insert into Calculated_History values(6,100,'USD','EUR',now(),100);