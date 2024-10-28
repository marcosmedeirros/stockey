create table usuarios(
                       idusuario bigserial not null primary key,
                       uuid UUID DEFAULT gen_random_uuid(),
                       nomeusuario varchar(50) not null,
                       emailusuario varchar(100) not null unique,
                       senhausuario varchar(100) not null,
                       permissao boolean not null
)