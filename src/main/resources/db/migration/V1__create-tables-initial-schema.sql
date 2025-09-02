-- Flyway Migration Script: V1__create-initial-schema.sql

-- Tabela para Pessoas (Emissores e Clientes)
-- Armazena informações de pessoas físicas ou jurídicas.
CREATE TABLE tbl_persons (
    -- Chave Primária
    id BIGSERIAL PRIMARY KEY,

    -- Campos de Domínio
    name VARCHAR(150) NOT NULL,
    document VARCHAR(18) NOT NULL UNIQUE,
    person_type VARCHAR(255) NOT NULL,

    -- Campos de Auditoria
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);


-- Tabela para Produtos
-- Armazena o catálogo de produtos e serviços.
CREATE TABLE tbl_products (
    -- Chave Primária
    id BIGSERIAL PRIMARY KEY,

    -- Campos de Domínio
    brand VARCHAR(150) NOT NULL,
    name VARCHAR(150) NOT NULL,
    category VARCHAR(255) NOT NULL,
    list_price NUMERIC(19, 2) NOT NULL,

    -- Campos de Auditoria
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);


-- Tabela Principal de Notas Fiscais (Invoices)
-- Centraliza as informações da nota, ligando emissor, cliente e seus itens.
CREATE TABLE tbl_invoices (
    -- Chave Primária
    id BIGSERIAL PRIMARY KEY,

    -- Campos de Domínio
    series VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    issue_date TIMESTAMP NOT NULL,
    amount_value NUMERIC(19, 2) NOT NULL,
    issuer_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,

    -- Campos de Auditoria
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    -- Constraints (Relacionamentos e Regras)
    CONSTRAINT fk_invoices_on_issuer FOREIGN KEY (issuer_id) REFERENCES tbl_persons(id),
    CONSTRAINT fk_invoices_on_customer FOREIGN KEY (customer_id) REFERENCES tbl_persons(id),
    CONSTRAINT uk_series_number UNIQUE (series, number) -- Garante que a combinação de série e número seja única
);


-- Tabela de Itens da Nota Fiscal
-- Tabela de ligação que detalha cada produto em uma nota fiscal.
CREATE TABLE tbl_invoice_items (
    -- Chave Primária
    id BIGSERIAL PRIMARY KEY,

    -- Campos de Domínio
    num_seq INTEGER NOT NULL,
    invoice_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    unity_value NUMERIC(19, 2) NOT NULL,

    -- Campos de Auditoria
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    -- Constraints (Relacionamentos)
    CONSTRAINT fk_invoice_items_on_invoice FOREIGN KEY (invoice_id) REFERENCES tbl_invoices(id),
    CONSTRAINT fk_invoice_items_on_product FOREIGN KEY (product_id) REFERENCES tbl_products(id)
);