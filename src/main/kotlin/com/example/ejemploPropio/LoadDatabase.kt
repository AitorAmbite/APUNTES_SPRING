package com.example.ejemploPropio

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoadDatabase {
    //esto siempre es asi
    companion object {
        // creamos el logger que nos va a servir para sacar infor por la consola
        var logger = LoggerFactory.getLogger(LoadDatabase.javaClass)
    }
    // a initDataBase debemos pasarle el respositorio de lo que queremos guardar que es la "bbdd"
    @Bean
    fun initDatabase(cryptoRepository: CryptoRepository): CommandLineRunner {

        return CommandLineRunner { args: Array<String?>? ->
            //aqui estamos insertando datos a la base de datos del propio spring.
            //para guardar datos seria CryptoRepository.save(CryptoCurrency(datos))
            logger.info("Preloading " + cryptoRepository.save(CryptoCurrency("btc-bitcoin", "bitcoin","BTC","COIN")))
            logger.info("Preloading " + cryptoRepository.save(CryptoCurrency("eth-ethereum", "Ethereum","ETH","COIN")))
            logger.info("Preloading " + cryptoRepository.save(CryptoCurrency("usdt-tether", "Tether","USDT","TOKEN")))
            logger.info("Preloading " + cryptoRepository.save(CryptoCurrency("xrp-xrp", "XRP","XRP","COIN")))

        }
    }
}