

public class LC_482_Liciense {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int dash = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='-') {
                dash++;
            }
        }
        if(dash == 0) return "";
        int start = dash%k;
        int index = 0;
        while(start >=1){
            if(s.charAt(index) !='-'){
                start--;
                if(Character.isLowerCase(s.charAt(index))){
                    sb.append(Character.toUpperCase(s.charAt(index)));
                }else{
                    sb.append(s.charAt(index));
                }
            }
            index++;
        }
        if((index>0) && (s.length() != 1)) sb.append("-");
        System.out.println(index);
        int count = k;
        for(int i = index;i<s.length();i++){
            if(s.charAt(i) != '-'){
                if(Character.isLowerCase(s.charAt(i))){
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }else{
                    sb.append(s.charAt(i));
                }
                count--;
                System.out.println(count);
            }
            if(count == 0 && i!=s.length()-1){
                sb.append("-");
                count = k;
            }
        }
        if(sb.charAt(sb.length()-1) == '-') sb.setCharAt(sb.length()-1,' ');
        return sb.toString().trim();
    }
}
