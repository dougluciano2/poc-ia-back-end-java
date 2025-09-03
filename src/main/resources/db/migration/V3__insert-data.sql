-- V3__insert-test-data.sql
-- Este script insere dados de teste para popular o sistema.

-- 1. Inserir Pessoas (Persons)
-- Corrigido: Usando o nome da tabela "tbl_persons"
INSERT INTO tbl_persons (name, document, person_type, created_at, updated_at) VALUES
('Tech Solutions Ltda', '11.222.333/0001-44', 'PJ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Global Services Inc.', '44.555.666/0001-77', 'PJ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Ana Livia da Silva', '123.456.789-00', 'PF', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- 2. Inserir Produtos (Products)
-- Corrigido: Usando o nome da tabela "tbl_products"
INSERT INTO tbl_products (brand, name, category, list_price, created_at, updated_at) VALUES
('Consultoria TI', 'Análise de Requisitos de Sistema', 'SERVICES', 150.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Suporte Técnico', 'Manutenção Preventiva de Servidores - Hora Técnica', 'SERVICES', 220.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Cable Corp', 'Cabo de Rede Cat6 - Metro', 'CABLES', 4.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('NetLink', 'Patch Panel 24 Portas Cat6', 'CABLES', 350.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('PowerConnect', 'Tomada Dupla 10A com Placa', 'PLUGS', 18.90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('SafePlug', 'Módulo de Tomada RJ45 (Keystone)', 'PLUGS', 12.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('FlexTube', 'Conduite Corrugado 3/4" - Rolo 50m', 'TUBIES', 85.75, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- 3. Inserir Notas Fiscais e Itens (Invoices & InvoiceItems)
-- Corrigido: Usando o nome da tabela "tbl_invoices"
INSERT INTO tbl_invoices (series, number, issue_date, amount_value, issuer_id, customer_id, status, created_at, updated_at) VALUES
('S1', '00001', '2025-08-10', 4500.00, 1, 2, 'DONE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Itens da Nota Fiscal 1
-- Corrigido: Usando o nome da tabela "tbl_invoice_items"
INSERT INTO tbl_invoice_items (num_seq, invoice_id, product_id, quantity, unity_value, created_at, updated_at) VALUES
(1, 1, 1, 30, 150.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- Nota Fiscal 2
-- Corrigido: Usando o nome da tabela "tbl_invoices"
INSERT INTO tbl_invoices (series, number, issue_date, amount_value, issuer_id, customer_id, status, created_at, updated_at) VALUES
('S1', '00002', '2025-09-01', 589.50, 1, 3, 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Itens da Nota Fiscal 2
-- Corrigido: Usando o nome da tabela "tbl_invoice_items"
INSERT INTO tbl_invoice_items (num_seq, invoice_id, product_id, quantity, unity_value, created_at, updated_at) VALUES
(1, 2, 3, 100, 4.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, 5, 5, 18.90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 2, 6, 3, 15.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);