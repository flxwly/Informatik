package org.extraterrestrial.qp34.MaulwurfReloadedApp;

public class Tier {
    public String name;
    public String farbe;
    public boolean fluessig;
    public char form;
    public int groesse;

    public Tier(String n, String f, boolean fl, char fo, int g) {
        name = n;
        farbe = f;
        fluessig = fl;
        form = fo;
        groesse = g;
    }

    // returns true if s1 is bigger than s2 and false if s1 and s2 are equal
    // true if s1 > s2
    private boolean stringCompare(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return true;
            }
        }
        return s1.length() > s2.length();
    }

    // returns true if t is "bigger"
    // true if t > this
    public boolean compare(Tier t) {
        return t.groesse > groesse || (t.groesse == groesse && !stringCompare(this.name, t.name));
    }

    @Override
    public String toString() {
        return "Tier{" +
                "name='" + name + '\'' +
                ", farbe='" + farbe + '\'' +
                ", fluessig=" + fluessig +
                ", form=" + form +
                ", groesse=" + groesse +
                '}';
    }

  /*public String getName()
  {
    return name;
  }
  
  public String getFarbe()
  {
    return farbe;
  } 
  */

}