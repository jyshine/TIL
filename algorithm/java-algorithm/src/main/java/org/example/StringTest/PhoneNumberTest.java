package org.example.StringTest;


class Solution{


    public int checkNumber(String phone_number) {
        int answer = -1;

        switch (phone_number.length()){
            case 11:
                if (!phone_number.startsWith("010") ){
                    break;
                }
                answer = 2;
                break;
            case 13:
                if (phone_number.split("-").length != 3){
                    break;
                }
                if (!phone_number.split("-")[0].equals("010") ){
                    break;
                }
                if (phone_number.split("-")[1].length() != 4 || phone_number.split("-")[2].length() != 4){
                    break;
                }
                answer = 1;
                break;
            case 16:
                if(!phone_number.split("-")[0].equals("+82")){
                    break;
                }
                if(!phone_number.split("-")[1].equals("10")){
                    break;
                }
                if(phone_number.split("-")[2].length()+phone_number.split("-")[3].length() != 8){
                    break;
                }
                answer = 3;

        }
        return answer;
    }
}
public class PhoneNumberTest{
    public static void main(String[] args) {
        String phone_number = "01012345678";
        String phone_number2 = "010-1234-5678";
        String phone_number3 = "+82-10-1234-5678";
        String phone_number4 = "+82-010-1234-5678";
        String phone_number5 = "+82-010-1234-567";
        Solution solution = new Solution();
        System.out.println(solution.checkNumber(phone_number));
        System.out.println(solution.checkNumber(phone_number2));
        System.out.println(solution.checkNumber(phone_number3));
        System.out.println(solution.checkNumber(phone_number4));
        System.out.println(solution.checkNumber(phone_number5));
    }

}