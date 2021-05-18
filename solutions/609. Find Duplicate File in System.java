class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        for(String path : paths){
            String[] files=path.split("\\s");
            for(int i=1;i<files.length;i++){
                //System.out.println("file->"+files[i]);
                String[] contents=files[i].split("[(]");
                //System.out.println("contents->"+contents[0]);
                List<String> list=map.get(contents[1]);
                if(list==null){
                    list=new ArrayList<>();
                    map.put(contents[1],list);
                }
                list.add(files[0]+"/"+contents[0]);
            }
            
        }
        List<List<String>> result=new ArrayList<>();
        for(Map.Entry<String,List<String>> data :  map.entrySet()){
            if(data.getValue().size()>1){
                result.add(data.getValue());
            }
        }
        return result;
    }
}
