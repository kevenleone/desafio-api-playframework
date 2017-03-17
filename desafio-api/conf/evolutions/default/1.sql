# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table usuario (
  id                            bigint auto_increment not null,
  nome                          varchar(255),
  email                         varchar(255),
  senha                         varchar(255),
  telefone                      varchar(255),
  criado                        datetime(6),
  modificado                    datetime(6),
  constraint pk_usuario primary key (id)
);


# --- !Downs

drop table if exists usuario;

