package Hashing;
import java.util.*;;
public class TestHashMap {
    
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();
        HashMap<String,String> hm1 = new HashMap<>();


        hm.put("us","United State");
        hm.put("in","India");
        hm.put("br", "Brazil");
        hm.put("es","Spain");

        hm1.put("af","Afghanistan");
        hm1.put("aq","Antartica");
        hm1.put("ar","Argentina Republic");

        // System.out.println(hm);
        // System.out.println(hm.size());
        // System.out.println(hm.keySet());
        // System.out.println(hm.get("es"));

        // hm1.put("in","Random");
        // hm.putAll(hm1); It overWrites key=in and put value= Random

        //add key value pair only when value associated to key is null or key is not present
        // hm.putIfAbsent("in","Africa"); 
        // System.out.println(hm);

        String s = hm.getOrDefault("es","Not Present");
        System.out.println(s);
        System.out.println(hm.getOrDefault("af","Not Present"));

        System.out.println(hm.containsKey("es"));
        System.out.println(hm.containsKey("sjhj"));

        System.out.println(hm.containsValue("India"));
        System.out.println(hm.containsValue("Africa"));

        System.out.println(hm.remove("es"));
        System.out.println(hm);

        System.out.println(hm.values());
        System.out.println(hm.keySet());

        Collection<String> al= new ArrayList<String>();
        al = hm.values();
        System.out.println(al);

        System.out.println(hm.entrySet());

        // Iteration Over Map

        for(Map.Entry<String,String> e: hm.entrySet()){
            System.out.println(e.getKey() +" :" + e.getValue());
        }
    }
}
