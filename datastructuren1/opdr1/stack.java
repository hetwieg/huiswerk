public class stack
{
    private studentElement start;
    private int size;

    /**
     *
     **/
    public stack()
    {

    }

    /**
     * Voeg een student toe aan de stack
     * @param s Student
     **/
    public void push(student s)
    {
	studentElement last = new studentElement(s);
	studentElement prev;

	if (size != 0)
	    {
		prev = getLast();
	    }
	else
	    {
		start = last;
		size++;
		return;
	    }      
	try
	    {
		prev.setVolgend(last);
	    }
	catch(studentStackExistsException e)
	    {
		System.out.println(e);
		return;
	    }
	size++;
    }

    /**
     * Geef de grote terug van de stack
     * @return int grote
     **/
    public int getSize()
    {
	return size;
    }

    /**
     * Geeft de laatste student terug
     * @return student Laatste student
     **/
    public student pop()
    {
	studentElement last = getLast();
	studentElement tmp = start;

	for (int i = 0; i < size -2; i++) // size - 1 om het laatste element te krijgen.
	    {
		tmp = tmp.getVolgend();
	    }
	try
	    {
		tmp.setVolgend(null);  // verwijder laatste element!
		size--;
	    }
	catch (studentStackExistsException e)
	    {
		System.out.println(e);
		return null;
	    }
	//size--;

	return last.getStudent();
    }

    /**
     * Controleer of een bepaalde student met dat studentnummer al aanwezig is
     * @param s student om te controleren.
     * @return boolean True indien aanwezig, anders false.
     **/
    public boolean peek(student s)
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		student t = tmp.getStudent();
		System.out.println(t.getStudent() == s.getStudent());
		if (s.getStudent() == t.getStudent())
		    {
			System.out.println("BLABLA");
			return true;
		    }
		tmp = start.getVolgend();	     
	    }

	return false;
    }

    /**
     * Print alle studenten
     **/
    public void printStack()
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		tmp.getStudent().printStudent();
		tmp = tmp.getVolgend();
	    }
    }

    /**
     * Print alle mannen
     **/
    public void printmen()
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		if (tmp.getStudent().getGeslacht() == "m")
		    {
			tmp.getStudent().printStudent();
		    }
		tmp = tmp.getVolgend();
	    }
    }
    /** 
     * Print alle vrouwen
     **/
    public void printwomen()
    {
	studentElement tmp = start;
	for (int i = 0; i < getSize(); i++)
	    {
		if (tmp.getStudent().getGeslacht() == "f")
		    {
			tmp.getStudent().printStudent();
		    }
		tmp = tmp.getVolgend();
	    }
    }

    private studentElement getLast()
    {
	studentElement vorig = start;
	for (int i = 0; i < size; i++)
	    {
		if (vorig.volgend())
		    {
			vorig = vorig.getVolgend();
		    }
		else
		    {
			return vorig;
		    }
	    }
	/*
	int i = 0;
	if (size <= 1)
	    {
		return start;
	    }
	System.out.println("START: " + size);
	do
	   {
	       System.out.println(i);
	       System.out.println(vorig);
	       i++;
	       vorig = vorig.getVolgend();
	   }
	while(vorig.volgend());
*/	System.out.println("ERROR!");
	return null;
    }
}