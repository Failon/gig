/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckData;

/**
 *
 * @author m3daw
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
public class Checking {
    public static int CheckDNI(String dni){
        int error;
        String LetraDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        Pattern valid = Pattern.compile("(\\d{7,8})[-]?([a-zA-Z])");
        Matcher MyMatcher = valid.matcher(dni);
        if(MyMatcher.find()){
            Integer numeros;
            numeros = Integer.parseInt(MyMatcher.group(1));
            Integer resto = numeros%23;
            String letra;
            letra = MyMatcher.group(2).toUpperCase();
            if(LetraDni.charAt(resto)==letra.charAt(0)){
                error = 0;                
            }
            else error = -1;
        }
        else error = -1;
        return error;
    }
    public static int CheckDates(String data){
        int error;
        int dias_mes[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        Pattern forma = Pattern.compile("(\\d{1,2})[/:-](\\d{1,2})[/:-](\\d{4})");
        Matcher MyMatcher = forma.matcher(data);
        if(MyMatcher.find()){
            Integer dia = Integer.parseInt(MyMatcher.group(1));
            Integer mes = Integer.parseInt(MyMatcher.group(2));
            Integer ano = Integer.parseInt(MyMatcher.group(3));
            if(Bisiesto(ano)) dias_mes[1]=29;
            if(mes>0&&mes<=12){
                if(dia>0&&dia<=dias_mes[mes-1]){
                    error = 0;
                }
                else error = -1;
            }
            else error = -1;
        }
        else error = -1;
        return error;
    }
    public static int DifData(String data1, String data2){
        int error, total1=0, total2=0;
        int checkdata1 = CheckDates(data1);
        int checkdata2 = CheckDates(data2);
        int dias_mes1[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dias_mes2[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        Pattern forma = Pattern.compile("(\\d{1,2})[/:-](\\d{1,2})[/:-](\\d{4})");
        Matcher MyMatcher1 = forma.matcher(data1);
        Matcher MyMatcher2 = forma.matcher(data2);
        if(checkdata1==0&&checkdata2==0){
            if(MyMatcher1.find()&&MyMatcher2.find()){
                Integer dia1 = Integer.parseInt(MyMatcher1.group(1));
                Integer dia2 = Integer.parseInt(MyMatcher2.group(1));
                Integer mes1 = Integer.parseInt(MyMatcher1.group(2));
                Integer mes2 = Integer.parseInt(MyMatcher2.group(2));
                Integer ano1 = Integer.parseInt(MyMatcher1.group(3));
                Integer ano2 = Integer.parseInt(MyMatcher2.group(3));
                
                if(Bisiesto(ano1)) dias_mes1[1]=29;
                if(Bisiesto(ano2)) dias_mes2[1]=29;
                
                for(int cont=1;cont<ano1;cont++){
                    total1 = total1+365;
                    if(Bisiesto(cont)) total1++;
                }
                for(int cont=1;cont<ano2;cont++){
                    total2 = total2+365;
                    if(Bisiesto(cont)) total2++;
                }
                for(int cont=0; cont<mes1;cont++){
                    if(cont<mes1-1){
                        total1 = total1 + dias_mes1[cont];
                    }
                    else total1 = total1 + dia1;
                }
                for(int cont=0; cont<mes2;cont++){
                    if(cont<mes2-1){
                        total2 = total2 + dias_mes2[cont];
                    }
                    else total2 = total2 + dia2;
                }
                if(total1>total2) error = total1 - total2;
                else error = total2 - total1;
            }
            else error = -1;
        }
        else error = -1;
        return error;
    }
    public static boolean Bisiesto(int ano){
        boolean bisiesto;
        if(ano%4==0&&(ano%100!=0||ano%400==0)){
            bisiesto = true;
        }
        else bisiesto = false;
        return bisiesto;
    }
    public static int CheckEmail(String email){
        int error;
        Pattern forma = Pattern.compile("([^@.][^@.]+)([@])([^@.][^@.]+)([.])([^@.][^@.]+)");
        Matcher MyMatcher = forma.matcher(email);
        if(MyMatcher.find()){
            error = 0;
        }
        else error = -1;
        return error;
    }
}


