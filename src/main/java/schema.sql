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
    client_id INTEGER NOT NULL,
    date DATE NOT NULL
);

CREATE TABLE sale_product (
    sale_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    product_value NUMERIC(10, 2) NOT NULL,
    PRIMARY KEY (sale_id, product_id)
);
