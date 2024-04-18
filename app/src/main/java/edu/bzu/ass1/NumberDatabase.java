package edu.bzu.ass1;


import java.util.ArrayList;
import java.util.List;

public class NumberDatabase {
    private List<Items> items= new ArrayList<Items>();
    public String[] getCategory(){
        String[] categories= {"From 0 to 9","From 10 to 19","From 20 to 90","Hundreds","Thousand and Above"};
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
        items.add(new Items("On", "Ten", "عشرة", "From 10 to 19"));
        items.add(new Items("On bir", "Eleven", "أحد عشر", "From 10 to 19"));
        items.add(new Items("On iki", "Twelve", "اثنا عشر", "From 10 to 19"));
        items.add(new Items("On üç", "Thirteen", "ثلاثة عشر", "From 10 to 19"));
        items.add(new Items("On dört", "Fourteen", "أربعة عشر", "From 10 to 19"));
        items.add(new Items("On beş", "Fifteen", "خمسة عشر", "From 10 to 19"));
        items.add(new Items("On altı", "Sixteen", "ستة عشر", "From 10 to 19"));
        items.add(new Items("On yedi", "Seventeen", "سبعة عشر", "From 10 to 19"));
        items.add(new Items("On sekiz", "Eighteen", "ثمانية عشر", "From 10 to 19"));
        items.add(new Items("On dokuz", "Nineteen", "تسعة عشر", "From 10 to 19"));
        items.add(new Items("Yirmi", "Twenty", "عشرون", "From 20 to 90"));
        items.add(new Items("Otuz", "Thirty", "ثلاثون", "From 20 to 90"));
        items.add(new Items("Kırk", "Forty", "أربعون", "From 20 to 90"));
        items.add(new Items("Elli", "Fifty", "خمسون", "From 20 to 90"));
        items.add(new Items("Altmış", "Sixty", "ستون", "From 20 to 90"));
        items.add(new Items("Yetmiş", "Seventy", "سبعون", "From 20 to 90"));
        items.add(new Items("Seksen", "Eighty", "ثمانون", "From 20 to 90"));
        items.add(new Items("Doksan", "Ninety", "تسعون", "From 20 to 90"));
        items.add(new Items("Yüz", "One Hundred", "مائة", "Hundreds"));
        items.add(new Items("İki Yüz", "Two Hundred", "مئتان", "Hundreds"));
        items.add(new Items("Üç Yüz", "Three Hundred", "ثلاثمائة", "Hundreds"));
        items.add(new Items("Dört Yüz", "Four Hundred", "أربعمائة", "Hundreds"));
        items.add(new Items("Beş Yüz", "Five Hundred", "خمسمائة", "Hundreds"));
        items.add(new Items("Altı Yüz", "Six Hundred", "ستمائة", "Hundreds"));
        items.add(new Items("Yedi Yüz", "Seven Hundred", "سبعمائة", "Hundreds"));
        items.add(new Items("Sekiz Yüz", "Eight Hundred", "ثمانمائة", "Hundreds"));
        items.add(new Items("Dokuz Yüz", "Nine Hundred", "تسعمائة", "Hundreds"));
        items.add(new Items("Bin", "One Thousand", "ألف", "Thousand and Above"));
        items.add(new Items("İki Bin", "Two Thousand", "ألفان", "Thousand and Above"));
        items.add(new Items("Üç Bin", "Three Thousand", "ثلاثة آلاف", "Thousand and Above"));
        items.add(new Items("On Bin", "Ten Thousand", "عشرة آلاف", "Thousand and Above"));
        items.add(new Items("Yüz Bin", "One Hundred Thousand", "مئة ألف", "Thousand and Above"));
        items.add(new Items("Milyon", "One Million", "مليون", "Million"));
        items.add(new Items("On Milyon", "Ten Million", "عشرة ملايين", "Million"));
        items.add(new Items("Yüz Milyon", "One Hundred Million", "مائة مليون", "Million"));
        items.add(new Items("Milyar", "One Billion", "بليون", "Billion"));
        items.add(new Items("On Milyar", "Ten Billion", "عشرة بلايين", "Billion"));
        items.add(new Items("Yüz Milyar", "One Hundred Billion", "مائة بليون", "Billion"));
        items.add(new Items("Milyar", "One Billion", "مليار", "Billion"));

    }
}