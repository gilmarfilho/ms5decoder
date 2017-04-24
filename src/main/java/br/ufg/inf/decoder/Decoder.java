package br.ufg.inf.decoder;

public class Decoder implements Runnable{
    Password passwords = Password.getInstance();

    private String getPassword() {
        String nextPassword = passwords.nextPassword();
        nextPassword = passwords.toMd5(nextPassword);
        
        //nextPassword = "17a0a00212dde12b063af7dc22fdf02b";

        return nextPassword;
    }
    
    @Override
    public void run() {
        while(passwords.getFinalTime() == 0){
            String generatedPassword = this.getPassword();
            if (generatedPassword.equals(passwords.getActualPassword())){
                    long finalTime = System.currentTimeMillis();
                    passwords.setFinalTime(finalTime);
            }
        }
    }
}
