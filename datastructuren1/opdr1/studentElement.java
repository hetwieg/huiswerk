public class studentElement
{
    private studentElement volgend = null;
    
    private student s;

    public studentElement(student data)
    {
	setStudent(data);
    }

    public void setStudent(student data)
    {
	s = data;
    }

    public student getStudent()
    {
	return s;
    }

    public boolean volgend()
    {
	if (volgend == null)
	    {
		return false;
	    }
	else
	    {
		return true;
	    }
    }
    public studentElement getVolgend()
    {
	if (volgend())
	    {
		return volgend;
	    }
	else
	    {
		return null;
	    }
    }
    public void setVolgend(studentElement v) throws studentStackExistsException
    {
	if (!volgend() || v == null) // Wanneer v null is willen we volgend verwijderen
	    {
		volgend = v;
	    }
	else
	    {
		throw new studentStackExistsException();
	    }
    }
}