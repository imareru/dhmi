package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User {
    private String login = "renata";
    private String password = "123456";


    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String newLogin){
        login = newLogin;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPassword){
        password = newPassword;
    }

    public void saveUserInfo() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("D:\\University\\2_semestr\\PCHMI\\Practika\\Scene_Builder\\lab5\\src\\sample\\users.txt", true));
        pw.println();
        pw.println(login + " " + password);
        pw.close();
    }
}
