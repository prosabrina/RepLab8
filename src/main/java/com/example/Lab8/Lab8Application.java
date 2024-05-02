package com.example.Lab8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Lab8Application implements CommandLineRunner {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Lab8Application.class, args);
	}
	
	public void run(String... strings) throws Exception {
		jdbcTemplate.query("SELECT id, actif, compte_creation, compte_maj, date_creation, date_maj, nom_arabe, nom_latin, nom_tamazight FROM wilaya ORDER BY id",
		        (rslt, rowNum) -> new Wilaya(rslt.getInt(1), rslt.getBoolean(2), rslt.getInt(3), rslt.getInt(4), rslt.getTimestamp(5), rslt.getTimestamp(6), rslt.getString(7), rslt.getString(8), rslt.getString(9))
		    ).forEach(w -> System.out.println(w));
	}
}
