create table produtos(
                         idproduto bigserial not null primary key,
                         uuid UUID DEFAULT gen_random_uuid(),
                         nomeproduto varchar(50) not null,
                         valor double precision not null,
                         quantidade integer not null,
                         idcategoria bigserial REFERENCES categorias(idcategoria), -- <== Vírgula adicionada aqui
                         idusuario bigserial REFERENCES usuarios(idusuario)
);


