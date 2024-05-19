import java.util.ArrayList;

public class keypadQ {
    public static void main(String[] args) {
        pad(" ", "12");
        System.out.println(padreturn(" ", "12").size());
        System.out.println(padcount(" ", "12"));
        System.out.println(dicret(" ", 4));
        System.out.println(diceFaceR(" ", 2, 6));

    }
    static void pad(String p , String up){
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch = (char) ('a'+i);
            pad(p + ch, up.substring(1));
        }
    }
    static ArrayList<String> padreturn(String p , String up){
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list; 
        }
        ArrayList<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch = (char) ('a'+i);
            list.addAll(padreturn(p + ch, up.substring(1)));
        }
        return list;
    }
    static int padcount(String p,String up){
        if (up.isEmpty()) {
            return 1;           
        }
        int count = 0;
        char ch = up.charAt(0);
        new ArrayList<>();
        for(int i=0;i<p.length();i++){
            String f = p.substring(0, i);
            String s = p.substring(i,p.length());
            count += padcount(f + ch + s, up.substring(1));
        }
        return count;
    }
    static ArrayList<String> dicret(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i=1;i<=6 && i<= target; i++){
            list.addAll(dicret(p+i,target-i));
        }
        return list;
        }
    static void diceFace(String p, int target ,int face){
        if (target==0){
            System.out.println(p);
            return;
        }
        for (int i=1;i<=face && i<=target;i++){
            diceFace(p+i, target-i, face);
        }
    }
    static ArrayList<String> diceFaceR(String p, int target,int face){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i=1;i<=face && i<= target; i++){
            list.addAll(diceFaceR(p+i,target-i,face));
        }
        return list;
        }
}
