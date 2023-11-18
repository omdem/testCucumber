package MailChimp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Random;

public class Registeruser {
    public static void main(String[] args) {

        WebDriver drivers;

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        drivers = new ChromeDriver(options);

        String url = "https://www.ica.se"; // replace with the URL of the page you want to scrape
        drivers.get(url);


    }









    public String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }




    public String generateRandomEmail() {
        String[] domains = {"hotmail.com", "google.com", "outlook.com"};
        String[] characters = "abcdefghijklmnopqrstuvwxyz".split("");

        StringBuilder username = new StringBuilder();
        StringBuilder domain = new StringBuilder();

        Random random = new Random();

        // Generate random username
        int usernameLength = random.nextInt(10) + 1; // Generate random length between 1 and 10
        for (int i = 0; i < usernameLength; i++) {
            username.append(characters[random.nextInt(characters.length)]);
        }

        // Select random domain
        domain.append(domains[random.nextInt(domains.length)]);

        return username.toString() + "@" + domain.toString();
    }

    public String generateRandomPassword() {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[{]}|;:'/,<.>/?`~";
        //The range of the password
        int minLength = 8;

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        //Add one lowercase character
        password.append(lowercaseChars.charAt(random.nextInt(lowercaseChars.length())));
        //Add one uppercase character
        password.append(uppercaseChars.charAt(random.nextInt(uppercaseChars.length())));
        //Add one number
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        //Add one special character
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        //Fill remaining characters randomly from all character groups
        for (int i = password.length(); i < minLength; i++) {
            String allChars = lowercaseChars + uppercaseChars + numbers + specialChars;
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        //Shuffle characters in the password
        StringBuilder shuffledPassword = new StringBuilder(password);
        for (int i = password.length() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = shuffledPassword.charAt(index);
            shuffledPassword.setCharAt(index, shuffledPassword.charAt(i));
            shuffledPassword.setCharAt(i, temp);
        }

        return shuffledPassword.toString();
    }
}



