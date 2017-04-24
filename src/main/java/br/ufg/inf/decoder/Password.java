package br.ufg.inf.decoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class Password {
    private ArrayList<String> passwordsGenerated = new ArrayList<>();
    private static Password password;
    private String actualPassword;
    private long finalTime = 0;
            
    public static Password getInstance(){
        if (password == null){
            password = new Password();
        }
        return password;
    }
    
    public void reset(){
        this.setFinalTime(0);
    }

    private ArrayList<String> getPasswordsGenerated() {
        return passwordsGenerated;
    }

    private void setPasswordsGenerated(ArrayList<String> passwordsGenerated) {
        this.passwordsGenerated = passwordsGenerated;
    }

    public long getFinalTime() {
        return this.finalTime;
    }

    public void setFinalTime(long finalTime) {
        this.finalTime = finalTime;
    }

    public String getActualPassword() {
        return actualPassword;
    }

    public void setActualPassword(String actualPassword) {
        this.actualPassword = actualPassword;
    }
    
    public void addPassword(String password){
        ArrayList<String> passwordsGenerated = this.getPasswordsGenerated();
        passwordsGenerated.add(password);
        this.setPasswordsGenerated(passwordsGenerated);
    }
    
    public String nextPassword() {
        String nextPassword;
        ArrayList<String> passwordsGenerated = this.getPasswordsGenerated();
        nextPassword = passwordsGenerated.remove(0);
        this.setPasswordsGenerated(passwordsGenerated);
        return nextPassword;
    }

    public String toMd5(String senha){
            String sen = "";
            MessageDigest md = null;
            try {
                    md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
            }
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            sen = hash.toString(16);			
            return sen;
    }

}