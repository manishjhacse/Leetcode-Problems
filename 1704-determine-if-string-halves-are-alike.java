class Solution {
    public boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
        return true;
        return false;
    }
    public boolean halvesAreAlike(String s) {
        int l=0;
        int h=s.length()-1;
        int vow1=0,vow2=0;
        while(l<=h){
            if(isVowel(s.charAt(l)))
            vow1++;
            if(isVowel(s.charAt(h)))
            vow2++;
            l++;
            h--;
        }
        return vow1==vow2;
    }
}