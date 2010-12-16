public class app
{
    public static void main(String[] arg)
    {
	stack st = new stack();
	for (int i = 0; i < 20; i++)
	    {
		// Data
		int leeftijd = 18 + (i / 2);
		String geslacht = ((i % 4) == 0) ? "f" : "m";
		String naam = "student " + i;
		int student = leeftijd * i;
		
		student s = new student(student, naam, geslacht, leeftijd);
		
		st.push(s);
	    }

	System.out.println("===============================================");
	st.printStack();
	System.out.println("===============================================M==");
	st.printmen();
	System.out.println("===============================================F==");
	st.printwomen();
	System.out.println("===============================================POP");

	student last = st.pop();

	last.printStudent();

	System.out.println("===============================================");
	st.printStack();
	st.push(last);
	//	s.printStudent();
    }
}