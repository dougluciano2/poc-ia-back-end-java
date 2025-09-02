-- Flyway Migration Script: V1__create-initial-schema.sql

-- Tabela para Pessoas (Emissores e Clientes)
-- Armazena informações de pessoas físicas ou jurídicas.
CREATE TABLE persons (
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
CREATE TABLE products (
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
CREATE TABLE invoices (
    -- Chave Primária
    id BIGSERIAL PRIMARY KEY,

    -- Campos de Domínio
    series VARCHAR(255) NOT NULL,
    number VARCHAR(255) NOT NULL,
    issue_date DATE NOT NULL,
    total_amount NUMERIC(19, 2) NOT NULL,
    issuer_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,

    -- Campos de Auditoria
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    -- Constraints (Relacionamentos e Regras)
    CONSTRAINT fk_invoices_on_issuer FOREIGN KEY (issuer_id) REFERENCES persons(id),
    CONSTRAINT fk_invoices_on_customer FOREIGN KEY (customer_id) REFERENCES persons(id),
    CONSTRAINT uk_series_number UNIQUE (series, number) -- Garante que a combinação de série e número seja única
);


-- Tabela de Itens da Nota Fiscal
-- Tabela de ligação que detalha cada produto em uma nota fiscal.
CREATE TABLE invoice_items (
    -- Chave Primária
    id BIGSERIAL PRIMARY KEY,

    -- Campos de Domínio
    invoice_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    unit_price NUMERIC(19, 2) NOT NULL,

    -- Campos de Auditoria
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    -- Constraints (Relacionamentos)
    CONSTRAINT fk_invoice_items_on_invoice FOREIGN KEY (invoice_id) REFERENCES invoices(id),
    CONSTRAINT fk_invoice_items_on_product FOREIGN KEY (product_id) REFERENCES products(id)
);