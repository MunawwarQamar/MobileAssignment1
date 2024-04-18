package edu.bzu.ass1;


import java.util.ArrayList;
import java.util.List;

public class NumberDatabase {
    private List<Items> items= new ArrayList<Items>();
    public String[] getCategory(){
        String[] categories= {"From 0 to 9","From 10 to 19","From 20 to 90","Hundreds","Thousand and above"};
        return categories;
    }
    public List<Items> getItems(String category){
        List<Items> result = new ArrayList<>();
        for(Items m: items){
            if(m.getCategory().equals(category)){
                result.add(m);
            }
        }
        return result;


    }
    public NumberDatabase(){
        items.add(new Items("Sıfır","Zero","صفر" , "From 0 to 9"));
        items.add(new Items("Bir","One","واحد" , "From 0 to 9"));
        items.add(new Items("Iki","Two","إثنان" , "From 0 to 9"));
        items.add(new Items("Üç","Three","ثلاثة" , "From 0 to 9"));
        items.add(new Items("Dört","Four","أربعة" , "From 0 to 9"));
        items.add(new Items("Beş","Five","خمسة" , "From 0 to 9"));
        items.add(new Items("Altı","Six","ستة" , "From 0 to 9"));
        items.add(new Items("Yedi","Seven","سبعة" , "From 0 to 9"));
        items.add(new Items("Sekiz","Eight","ثمانية" , "From 0 to 9"));
        items.add(new Items("Dokuz","Nine","تسعة" , "From 0 to 9"));
    }
}