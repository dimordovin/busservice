package com.dimordovin.busservice;


import com.dimordovin.busservice.util.FileStationMapReader;
import com.dimordovin.busservice.util.StationMapReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("filename is missing");
        }

        System.setProperty("map.reader.filename", args[0]);

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public StationMapReader getStationMapReader(@Value("${map.reader.filename}") String filename) {
        return new FileStationMapReader(filename);
    }
}