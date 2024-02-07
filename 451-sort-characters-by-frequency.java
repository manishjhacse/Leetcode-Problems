class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        StringBuilder ans=new StringBuilder();
        List<Character>[]arr=new ArrayList[s.length()+1];
        for (int i = 0; i <s.length() ; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        map.keySet().forEach(
            c->{
                if(arr[map.get(c)]==null){
                    arr[map.get(c)]=new ArrayList<>();
                }
                arr[map.get(c)].add(c);
            }
        );
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]!=null){
                for(Character c:arr[i]){
                    for(int j=0;j<i;j++){
                        ans.append(c);
                    }
                }
            }
        }
        return ans.toString();  
    }
}