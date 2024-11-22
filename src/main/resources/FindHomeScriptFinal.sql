CREATE SCHEMA  findhome;
 
drop schema if exists findhome;
drop user if exists usuario_admin;
CREATE SCHEMA findhome;
 
create user 'usuario_admin'@'%' identified by 'Usuar1o_Clave.';
 
grant all privileges on findhome.* to 'usuario_admin'@'%';
flush privileges;
 
create table findhome.categoria (
id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  activo bool,
  PRIMARY KEY (id_categoria)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
 
CREATE TABLE findhome.casas(
  id_casa INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(1600) NOT NULL,  
  metros_cuadrados VARCHAR(1600) NOT NULL, 
  precio double,
  contacto int,
  ubicacion VARCHAR(1600) NOT NULL,
  cuartos INT NOT NULL,  
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_casa),
  foreign key fk_propiedad_categoria (id_categoria) references categoria(id_categoria) 
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE findhome.lotes(
  id_lote INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(1600) NOT NULL,  
  metros_cuadrados VARCHAR(1600) NOT NULL, 
  precio double,
  contacto int,
  ubicacion VARCHAR(1600) NOT NULL,
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_lote),
  foreign key fk_propiedad_categoria (id_categoria) references categoria(id_categoria) 
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE findhome.locales(
  id_local INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(1600) NOT NULL,  
  metros_cuadrados VARCHAR(1600) NOT NULL, 
  precio double,
  contacto int,
  ubicacion VARCHAR(1600) NOT NULL,  
  ruta_imagen VARCHAR(1024),
  PRIMARY KEY (id_local),
  foreign key fk_propiedad_categoria (id_categoria) references categoria(id_categoria) 
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
  
  create table findhome.usuario(
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (id_usuario)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
 
create table findhome.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
 
insert into findhome.rol (id_rol, nombre, id_usuario) values
(1,'ROLE_ADMIN',1), (2,'ROLE_USER',1);

INSERT INTO findhome.categoria (id_categoria, descripcion, activo) VALUES
('1','Venta',true),
('2','Alquiler',true);
 
INSERT INTO findhome.casas (id_casa, id_categoria, descripcion, metros_cuadrados, precio, contacto, ubicacion, cuartos, ruta_imagen) VALUES
('1','1','Local en venta','60','2500000','88888888','Moravia frente al Higueron','2', 'https://i.blogs.es/c68014/casa-3d/1366_2000.jpeg'),
('2','2','Casa en venta','30','4600000','88888888','Cartago ochomogo','4', 'https://assets.arquitecturaviva.com/assets/uploads/articulos/71318/av_medium__av_182045.webp?h=87ae05d2');
 
 INSERT INTO findhome.lotes (id_lote, id_categoria, descripcion, metros_cuadrados, precio, contacto, ubicacion, ruta_imagen) VALUES
('1','1','Local en venta','60','2500000','88888888','Moravia frente al Higueron', 'https://i.blogs.es/c68014/casa-3d/1366_2000.jpeg'),
('2','2','Casa en venta','30','4600000','88888888','Cartago ochomogo', 'https://assets.arquitecturaviva.com/assets/uploads/articulos/71318/av_medium__av_182045.webp?h=87ae05d2');

INSERT INTO findhome.locales (id_local, id_categoria, descripcion, metros_cuadrados, precio, contacto, ubicacion, ruta_imagen) VALUES
('1','1','Local en venta','60','2500000','88888888','Moravia frente al Higueron', 'https://i.blogs.es/c68014/casa-3d/1366_2000.jpeg'),
('2','2','Casa en venta','30','4600000','88888888','Cartago ochomogo', 'https://assets.arquitecturaviva.com/assets/uploads/articulos/71318/av_medium__av_182045.webp?h=87ae05d2');
 
INSERT INTO findhome.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'juan','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg',true),
(2,'rebeca','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Rebeca',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789','https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg',true),
(3,'pedro','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Pedro', 'Mena Loria',     'lmena@gmail.com',      '7898-8936','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854',true);
