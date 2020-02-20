package Excercise1;

import java.util.Set;

public class Model
{
    Integer key;
    String value;

    public Model(int key, String value){
        this.key = key;
        this.value = value;
    }
    public Model(String key, String value){
        this.key = Integer.parseInt(key);
        this.value = value;
    }
    public Model(String line){
        String[] mas = line.split(",");
        this.key = Integer.parseInt(mas[0]);
        this.value = mas[1];
    }

    public Model(String[] mas){
        this.key = Integer.parseInt(mas[0]);
        this.value = mas[1];
    }

    public Integer getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}
