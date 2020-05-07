CREATE TABLE order_enum_value (
    ORDER_ID varchar(20) PRIMARY KEY NOT NULL,
    ORDER_STATUS CHAR(20)
);
INSERT INTO order_enum_value ( "ORDER_ID", "ORDER_STATUS" )
    VALUES ('123', 'CANCELLED');
INSERT INTO order_enum_value ( "ORDER_ID", "ORDER_STATUS" )
    VALUES ('456', 'cancelled');
INSERT INTO order_enum_value ( "ORDER_ID", "ORDER_STATUS" )
    VALUES ('789', null);
INSERT INTO order_enum_value ( "ORDER_ID", "ORDER_STATUS" )
    VALUES ('abc', 'XXX');



CREATE TABLE order_char_value (
    ORDER_ID varchar(20) PRIMARY KEY NOT NULL,
    ORDER_STATUS char
);
INSERT INTO order_char_value ( "ORDER_ID", "ORDER_STATUS" )
VALUES ('123', 'X');
INSERT INTO order_char_value ( "ORDER_ID", "ORDER_STATUS" )
VALUES ('456', 'P');