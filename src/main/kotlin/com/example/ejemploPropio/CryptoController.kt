package com.example.ejemploPropio

import org.springframework.web.bind.annotation.*
// ESTE ES EL CONTROLADOR DONDE TENDREMOS TODAS LAS RUTAS DE LA APLICACION.
@RestController
class CryptoController(private val cryptoRepository:CryptoRepository) {
    // la anotacion @getMapping("ruta") nos permite recibir las llamadas a esa ruta y ejecutar una funcion
    // es decir asignamos una funcion a esa ruta
    // @GetMapping -> rutas get la informacion va en la url
    //@PostMapping -> rutas post informacion pasada por cabeceras - cuerpo de html etc.
    //para recibir parametros por la ruta encapsularemos el parametro entre {parametro}
    // y en la funcion pasaremos como parametro @PathVariable nombreParamtro : TIPO
    @GetMapping("/coins")
    fun getCoins():List<CryptoCurrency>{
        return cryptoRepository.findAll()
    }
    @GetMapping("/coins/{id}")
    fun getSpecificCoin(@PathVariable id: Long):CryptoCurrency{
        return cryptoRepository.findById(id).get()
    }
    @GetMapping("/coins/getMax/{number}")
    fun getMaxCoins(@PathVariable number: Int): MutableList<CryptoCurrency> {
        return cryptoRepository.findAll().subList(0,number)
    }
    @PostMapping("/rutaPost")
    fun setCoin(@RequestBody coin:CryptoCurrency){
        cryptoRepository.save(coin)
    }
    @DeleteMapping("/coin/{id}")
    fun delCoin(@PathVariable id: Long){
        cryptoRepository.deleteById(id)
    }
}