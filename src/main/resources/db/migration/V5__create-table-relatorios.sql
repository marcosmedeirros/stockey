CREATE TABLE relatorios (
                            idrelatorio bigserial not null primary key,
                            uuid UUID DEFAULT gen_random_uuid(),
                            nomerelatorio varchar(50) not null,
                            tipo VARCHAR(25),
                            idproduto bigserial not null REFERENCES produtos(idproduto),
                            qtdalterada double precision,
                            qtdatualizada double precision,
                            data VARCHAR(255)
);
