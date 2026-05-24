package zadanie31;

public class Produkt {
    public String name;
    public double price;
    public int count;
    public String code;
    public boolean codeGrade;

    public Produkt(String name, double price, int count, String code) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.code = code;
        this.codeGrade = isCodeRight(code);
    }

    public boolean isCodeRight(String code){

        int sum = 0;

        if (code.length() != 11) {
            return false;
        }


        sum += (code.charAt(0) - '0') * 1;
        sum += (code.charAt(1) - '0') * 3;
        sum += (code.charAt(2) - '0') * 7;
        sum += (code.charAt(3) - '0') * 9;
        sum += (code.charAt(4) - '0') * 1;
        sum += (code.charAt(5) - '0') * 3;
        sum += (code.charAt(6) - '0') * 7;
        sum += (code.charAt(7) - '0') * 9;
        sum += (code.charAt(8) - '0') * 1;
        sum += (code.charAt(9) - '0') * 3;

        int num = sum % 10;

        if (num == 0){
            if ((code.charAt(10) - '0') == 0){
                return true;
            }
        }else {
            if ((code.charAt(10)- '0')  == 10 - num){
                this.code = code;
                return true;
            }
        }


        return false;
    }

    public String createCode(){
        char prev = 0;
        String str = "";
        for (int i = 0; i < name.length(); i++) {
            char a = name.charAt(i);
            if (a != prev){
                if (changeLetter(a)){
                    str = str + "*";
                }else{
                    str = str + a;
                }
            }
            prev = a;
        };



        return str;


    }

    public boolean changeLetter(char a){
        char[] tab = {'a', 'e', 'i', 'o', 'u', 'ą', 'ę', 'ó', 'A', 'E', 'I', 'O', 'U', 'Ą', 'Ę', 'Ó'};
        for (char s : tab){
            if (a == s){
                return true;
            }
        }
        return false;
    }




    @Override
    public String toString() {
        return  name +
                "   |    " + price +
                "   |    " + count + " szt" +
                "   |    " + code;
    }
}
