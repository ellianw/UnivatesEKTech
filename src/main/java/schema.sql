/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Ellian
 * Created: 12 de mai. de 2025
 */

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255),
    active BOOLEAN NOT NULL
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    value NUMERIC(10, 2) NOT NULL,
    stock INTEGER NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE TABLE sale (
    id SERIAL PRIMARY KEY,
    ref_client INTEGER NOT NULL,
    ref_user INTEGER NOT NULL,
    date DATE NOT NULL
);

CREATE TABLE sale_product (
    ref_sale INTEGER NOT NULL,
    ref_product INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    product_value NUMERIC(10, 2) NOT NULL,
    PRIMARY KEY (ref_sale, ref_product)
);

CREATE TABLE users (
    id SERIAL NOT NULL,
    login VARCHAR(40) NOT NULL,
    name VARCHAR(160) NOT NULL,
    password VARCHAR(1028) NOT NULL,
    privilege INTEGER NOT NULL,
    active BOOLEAN NOT NULL
);

INSERT INTO users VALUES (DEFAULT, 'admin', 'Administrador EKTech', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',1,true); -- Default password = admin
INSERT INTO users VALUES (DEFAULT, 'ellian', 'Ellian Wolfart', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,true); -- Default password = 123
INSERT INTO users VALUES (DEFAULT, 'karen', 'Karen Drus', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3',1,true); -- Default password = 123