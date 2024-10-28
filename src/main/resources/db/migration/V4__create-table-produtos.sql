create table produtos(
                        idproduto bigserial not null primary key,
                        uuid UUID DEFAULT gen_random_uuid(),
                        nomeproduto varchar(50) not null,
                        valor double precision not null,
                        quantidade integer not null,
                        idcategoria bigserial not null REFERENCES categorias(idcategoria)
)