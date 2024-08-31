package com.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ScmApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		// Set system properties from .env file
		System.setProperty("GOOGLE_CLIENT_NAME", dotenv.get("GOOGLE_CLIENT_NAME"));
		System.setProperty("GOOGLE_CLIENT_ID", dotenv.get("GOOGLE_CLIENT_ID"));
		System.setProperty("GOOGLE_CLIENT_SECRET", dotenv.get("GOOGLE_CLIENT_SECRET"));
		System.setProperty("GOOGLE_SCOPE", dotenv.get("GOOGLE_SCOPE"));

		System.setProperty("GITHUB_CLIENT_NAME", dotenv.get("GITHUB_CLIENT_NAME"));
		System.setProperty("GITHUB_CLIENT_ID", dotenv.get("GITHUB_CLIENT_ID"));
		System.setProperty("GITHUB_CLIENT_SECRET", dotenv.get("GITHUB_CLIENT_SECRET"));
		System.setProperty("GITHUB_SCOPE", dotenv.get("GITHUB_SCOPE"));

		// CLOUDINARY
		System.setProperty("CLOUDINARY_CLOUD_NAME", dotenv.get("CLOUDINARY_CLOUD_NAME"));
		System.setProperty("CLOUDINARY_API_KEY", dotenv.get("CLOUDINARY_API_KEY"));
		System.setProperty("CLOUDINARY_API_SECRET", dotenv.get("CLOUDINARY_API_SECRET"));
		SpringApplication.run(ScmApplication.class, args);

		// Mailtrap
		System.setProperty("MAILTRAP_USERNAME", dotenv.get("MAILTRAP_USERNAME"));
		System.setProperty("MAILTRAP_PASSWORD", dotenv.get("MAILTRAP_PASSWORD"));

	}

}
