package br.ufg.inf.decoder;

public class Generator implements Runnable{
    Password password = Password.getInstance();
       
    private void passwordGenerator(){
        String possibleLetters = "abcdefghijklmnopqrstuvxyz1234567890";
        String generatedPassword = "";
        outer:
        for (char letter1 : possibleLetters.toCharArray()){
            for (char letter2 : possibleLetters.toCharArray()){
                for (char letter3 : possibleLetters.toCharArray()){
                    for (char letter4 : possibleLetters.toCharArray()){
                        for (char letter5 : possibleLetters.toCharArray()){
                            if(password.getFinalTime() != 0){
                                break outer;
                            }
                            generatedPassword = "" + letter1 + letter2 + letter3 + letter4 + letter5;
                            password.addPassword(generatedPassword);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void run() {
        this.passwordGenerator();
    }
}
