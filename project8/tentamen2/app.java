public class app
{
    public static void main(String args[])
    {
	System.out.println("Programma starten");

	// Load screen starten
	LoadScreen.Update("Hallo allemaal", 10);
	
	String[] andwoorde = {"J|Ja", "N|Nee"};//, "C|Kippen zijn groen", "D|Heksen zijn vlaams\ndd\n..\nhallo"};
	Vraag.Show("Is 1 + 1 = 2", andwoorde, 1000);
	LoadScreen.Close();

	try {
	    Thread.sleep(20000);
	}
	catch(InterruptedException ex) {
	    // Doe iets met error
	}
	
	System.out.println("Afnamen software beindigt");
	System.exit(0); // Force exit
    }
}