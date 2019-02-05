CREATE TABLE customer(customerid bigint not null,address varchar,contact_number bigint,customer_name varchar,gender varchar,PRIMARY KEY(customerid));

CREATE TABLE inventory(sku_id bigint not null,inventory_on_hand integer not null,min_qty_req integer not null,price double not null,product_label varchar,product_name varchar,PRIMARY KEY(sku_id));

CREATE TABLE vendor(vendor_id bigint not null,vendor_address varchar,vendor_contact_no bigint,vendor_email varchar,vendor_name varchar,vendor_username varchar,PRIMARY KEY(vendor_id));
