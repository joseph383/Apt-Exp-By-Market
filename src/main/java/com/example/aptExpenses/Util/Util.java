package com.example.aptExpenses.Util;

import java.util.ArrayList;

public class Util {
    
    public String concatArrayListString(ArrayList<String> list) {

    StringBuffer sb = new StringBuffer();
      
      for (String s : list) {
         sb.append(s);
         sb.append(" ");
      }
      String str = sb.toString();
      return str;

}

}
