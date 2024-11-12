CREATE TABLE categorias (
                            idcategoria bigserial NOT NULL PRIMARY KEY,
                            uuid UUID DEFAULT gen_random_uuid(),
                            nomecategoria VARCHAR(50) NOT NULL
);
