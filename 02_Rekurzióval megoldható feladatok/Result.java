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
            
            // legelso sor: tesztesetek szama
        // masodik sor: a tombben/taroloban talalhato string-ek szama
        // harmadik sor: loginAttempt, egy string, amely a probalkozasunkat reprezentalja

        // feladat: probaljuk kirakni a taroloban talalhato string-ekbol a loginAttempt string-et

        // a tarolobol egy string-et akarmennyiszer felhasznalhatunk
        // visszateresi ertek: felhasznalt string-ek megfelelo sorrendben, space-szel elvalasztva

        // elso megkozelites:

        // kezdjunk el vegigiteralni a kapott string-eken
        // a vizsgalt string-et adott hosszban hasonlitsuk ossze a loginAttempt substring-javel
        // (nulladik indextol hossz mennyisegu string-et)

        // amennyiben beillesztheto:
        // mentsuk el a string-et egy result valtozoba -- vagy valami stringbuilder szerusegbe
        // vagjuk ki a talalt string-et a loginAttempt-bol -- tehat masoljuk at a loginAttempt substring-jet egy masik valtozoba
        // az uj valtozora hivjuk meg ujra a fugvenyt, itt tortenik meg a rekurzio

        // amennyiben nem beillesztheto, es van meg a taroloban mas string is:
        // nezzuk meg a kovetkezo string-et, es igy tovabb

        // ha mar nincs string, es egyik sem volt beillesztheto:
        // visszaterunk a WRONG PASSWORD string-gel
        
        
            if(loginAttempt.isEmpty()) {
            return "";
        }
        
      
        // csak azokkal foglalkozzunk, ami benne lehet a loginAttempt-ben, ezzel javitva gyorsasagon
        List<String> validPasswords = new ArrayList<>();
        for (String password : passwords) {
                if (loginAttempt.contains(password)) {
                    validPasswords.add(password);
        }
    }
        
          // Hozzuk letre az iteratort
        Iterator<String> iterator = validPasswords.iterator();
      
        // Keressuk meg azt a reszt, amely egyezik a loginAttempt elejevel
        while(iterator.hasNext()) {
            String passSubString = iterator.next();
            
    
            
            // ha a vizsgalt stringgel kezdodik, es nem kell tobb darakbat talalnunk
            if(loginAttempt.startsWith(passSubString)) {
                String result = passwordCracker(validPasswords, loginAttempt.substring(passSubString.length()));
               if(!result.equals("WRONG PASSWORD")) {
                return passSubString + (result.isEmpty() ? "" : " " + result);
                }
            }
           
        }
         return "WRONG PASSWORD";
    }

}
