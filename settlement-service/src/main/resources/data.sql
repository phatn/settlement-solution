-- ================================ Party Account Data ================================================
INSERT INTO party_account (account_number, account_bank) VALUES 
	('05461368', 'DBSSGB2LXXX'),
	('438421', 'OCBCSGSGXXX'),
	('05461369', 'DBSSSGSGXXX'),
	('185586', 'DBSSSGSGXXX'),
	('1868422', 'SCBLAU2SXXX'),
	('00454983', 'CITIGB2LXXX'),
	('48486414', 'GSCMUS33XXX');
	
-- ================================ SSI Reference Data ================================================
INSERT INTO ssi_reference(ssi_code, payer_party_id, receiver_party_id, supporting_information) VALUES
('DBS_OCBC_1', 1, 2, 'BNF:PAY CLIENT'),
('OCBC_DBS_1', 2, 1, 'BNF:FFC-4697132'),
('OCBC_DBS_2', 2, 3, 'BNF:FFC-482315'),
('DBS_SCB', 4, 5, 'RFB:Test payment'),
('CITI_GS', 6, 7, '');


-- ================================ Currency ================================================
INSERT INTO currency (name, code, symbol) VALUES ('Dollars', 'USD', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Pesos', 'ARS', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Dollars', 'AUD', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Euro', 'EUR', '€');
INSERT INTO currency (name, code, symbol) VALUES ('Dollars', 'SGD', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Dollars', 'CAD', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Pounds', 'GBP', '£');
INSERT INTO currency (name, code, symbol) VALUES ('Dollars', 'HKD', '$');
INSERT INTO currency (name, code, symbol) VALUES ('Dong', 'VND', '₫');
INSERT INTO currency (name, code, symbol) VALUES ('Dollars', 'NZD', '$');


-- ================================ Settlement Message ================================================
INSERT INTO settlement(trade_id, message_id, amount, value_date, currency_id, ssi_code) VALUES
(16846548, 'e8a57dc0-2119-49a4-85fe-5e94415b2cad', 12894.65, '2020-02-20', 1, 1);