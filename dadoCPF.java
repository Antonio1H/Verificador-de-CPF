import java.util.Scanner;

public class  DadoCPF{
    Scanner sc = new Scanner(System.in);

    public static boolean verificar(String cpf){
        char letra;
        int tam = cpf.length();
        if(tam != 11){
            return false;
        }
        else if (tam == 11){
            for(int i = 0; i<tam; i++){
                letra = cpf.charAt(i);
                if(!Character.isDigit(letra)){
                    return false;
                }
            }
        }
        return true;
    }

    public static int transfomaCharInt(char valor) {
        int num;
        num = valor - '0';
        return num;
    }

    public static boolean digitoVerificado(String cpf){
        char valor1,valor2;
        int soma1=0,soma2=0;
        int posi1 = 0 , posi2 = 0;
        int num1,num2;
        int digitoV1,digitoV2;
        int rest1,rest2;

        //verifica Dig1
        for (int i = 10 ; i > 1; i--) {
            valor1 = cpf.charAt(posi1);
            num1= transfomaCharInt(valor1);
            soma1 += num1 * i;
            posi1++;
        }
        
        rest1 = soma1%11;
        if (rest1 < 2) {
             digitoV1 = 0;
        } else {
            digitoV1 = 11 - rest1;
        }
        
        //verifica Dig2
        for(int i= 11; i>1 ;i--){
            valor2 = cpf.charAt(posi2);
            num2= transfomaCharInt(valor2);
            soma2 += num2 * i;
            posi2++;
        }
        
        rest2 = soma2%11;
        if (rest2 < 2) {
            digitoV2 = 0;
        } else {
            digitoV2 = 11 - rest2;
        }

        for(int i = 10; i>1 ; i++){   
            if(digitoV1 != cpf.charAt(9) - '0' && digitoV2 != cpf.charAt(10) - '0'){
                return false;
            }
        }
        return true;
    }

     public static void main(String[] args) {
         String cpf;
         boolean validar;
         Scanner sc = new Scanner(System.in);
         System.out.println("Digite o CPF: ");
         cpf = sc.nextLine();        
         
         validar = verificar(cpf);
         
         while(validar == false){
             System.out.println(" Padrão do CPF não corresponde, Digite novamente o CPF: ");
             cpf = sc.nextLine();
             validar = verificar(cpf);
        }
        if(validar == true){
            if(digitoVerificado(cpf)==true){
                System.out.println("CPF digitado : " + cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9)
                + "-" + cpf.substring(9) + " é válido.");
            }else{
                System.out.println("CPF invalido!");
            }
             
        }
    }
}