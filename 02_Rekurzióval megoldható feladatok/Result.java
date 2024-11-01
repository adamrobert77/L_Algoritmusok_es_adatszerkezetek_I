class Result {

    /*
     * Complete the 'passwordCracker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING loginAttempt
     */

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
            // Write your code here
            
          
        
        // Amennyiben a loginAttempt ures, terjunk vissza ures String-gel --- ez kelleni fog a megfelelo rekurziv megoldashoz
            if(loginAttempt.isEmpty()) {
            return "";
        }
        
      
        // Csak azokon iteralunk vegig, amelyek egyaltalan megtalalhatoak a loginAttempts-ben, tobbi elem redundans
        List<String> validPasswords = new ArrayList<>();
        for (String password : passwords) {
                if (loginAttempt.contains(password)) {
                    validPasswords.add(password);
            }
        }
        
        // Hozzuk letre az iteratort
        Iterator<String> iterator = validPasswords.iterator();
      
        // Iteraljunk vegig a megfelelo substring-eken, megoldas darakban
        while(iterator.hasNext()) {
            String passSubString = iterator.next();
        
            // Ha a vizsgalt string-gel kezdodik, hivjuk meg ujra a fuggvenyt, de redukalt loginAttempt substring-gel
            if(loginAttempt.startsWith(passSubString)) {
                // Toroljuk ki azt a string-et a loginAttempt elejebol, amit talaltunk, keressuk meg a tobbi reszmegoldast
                String result = passwordCracker(validPasswords, loginAttempt.substring(passSubString.length()));

                // Ha ertelmezheto megoldast kapunk, fuzzuk hozza a most talalt darabkahoz az alabbi feltetelek szerint
               if(!result.equals("WRONG PASSWORD")) {
                return passSubString + (result.isEmpty() ? "" : " " + result);
                }
            }
           
        }
        // Ha semmit nem talaltunk, terjunk vissza a wrong password-dal
         return "WRONG PASSWORD";
    }

}
