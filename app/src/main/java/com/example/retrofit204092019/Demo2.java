package com.example.retrofit204092019;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Demo2 {

@SerializedName("danhsach")
@Expose
private List<Danhsach> danhsach = null;

public List<Danhsach> getDanhsach() {
return danhsach;
}

public void setDanhsach(List<Danhsach> danhsach) {
this.danhsach = danhsach;
}

}