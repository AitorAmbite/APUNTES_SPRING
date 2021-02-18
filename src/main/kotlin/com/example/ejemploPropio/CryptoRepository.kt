package com.example.ejemploPropio

import org.springframework.data.jpa.repository.JpaRepository
//AQUI ESTAMOS CREANDO LA BASE DE DATOS PARA CREARLA DEBEMOS USAR LA SIGUIENTE SINTAXIS
//NombreClaseKT:JpaRepository<claseKT_datos, tipo ID> si hemos creado el id como int habria que poner int
interface CryptoRepository:JpaRepository<CryptoCurrency, Long>

//para guardar datos seria CryptoRepository.save(CryptoCurrency(datos))