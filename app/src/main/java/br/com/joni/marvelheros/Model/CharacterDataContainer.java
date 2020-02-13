package br.com.joni.marvelheros.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CharacterDataContainer implements Serializable {

    public String offset;
    public String limit;
    public String total;
    public String count;
    public List<Character> results;


}
