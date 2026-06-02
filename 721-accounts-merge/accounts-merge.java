class DisjointSet{
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();
    DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int ulp= findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void union(int u, int v){
        int ulpU= findUPar(u);
        int ulpV= findUPar(v);
        if(ulpU == ulpV) return;
        if(size.get(ulpU) > size.get(ulpV)){
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }else{
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpU) + size.get(ulpV));    
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n= accounts.size();
        HashMap<String, Integer> map= new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail= accounts.get(i).get(j);
                if(map.containsKey(mail) == false){
                    map.put(mail, i);
                }else{
                    ds.union(i, map.get(mail));
                }
            }
        }
        ArrayList<String>[] mergedMail= new ArrayList[n];
        for(int i=0; i<n; i++){
            mergedMail[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> it : map.entrySet()){
            String mail= it.getKey();
            int node= ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> list= new ArrayList<>();
        for(int i=0; i<n; i++){
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp= new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergedMail[i]){
                temp.add(it);
            }
            list.add(temp);
        }
        return list;
    }
}