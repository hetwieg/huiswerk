import java.util.*;

public class Vraag {
    public String l_Vraag = "";
    public String l_Info = "";
    public String l_Tijd = "";
    public String l_Punten = "";
    public String l_Buttons = "";
    public List<Andwoord> l_Andwoorden = new ArrayList<Andwoord>();

    public Vraag() { }
    
    public void setVraag(String vraag) {l_Vraag = vraag; }
    public void setInfo(String info) {l_Info = info;}
    public void setTijd(String tijd) {l_Tijd = tijd;} // parse
    public void setPunten(String punten) {l_Punten = punten;} // parse
    public void setButtons(String buttons) {l_Buttons = buttons;}

    public void Shuffel()
    {
        System.out.println("Lets shuffel");
    }

    public void addAndwoord(String andwoord, boolean juist)
    {
	// Gegevens van Andwoord;
	//System.out.println(andwoord);
        l_Andwoorden.add(new Andwoord(andwoord, juist));
    }
    
    public void Show(int VraagNummer)
    {
        System.out.println(l_Vraag);
	// Vraag laten zien met deze gegevens

        VraagGui.Show(this, VraagNummer);
    }
}