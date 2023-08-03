import java.util.*;
class Exam {
Scanner obj = new Scanner(System.in);
HashMap<String,Integer> ms = new HashMap<String,Integer>();
    public void Ulogin() {
		ms.put("ajay",1111);
		System.out.println("\n------ HELLO!!...WELCOME TO THE ONLINE EXAM PORTAL ------");
		String Uname;
		System.out.println(" Please Enter UserName : ");
		Uname = obj.next();
		int PWD;
		System.out.println("Please Enter numeric Password  : ");
		PWD= obj.nextInt();
		if(ms.containsKey(Uname)) {
			if(ms.get(Uname)==PWD){
				System.out.println("\n Welcome @ User");
				Options_Menu();	}
			else {
				System.out.println("Please Enter Valid Password For: "+Uname);
				Ulogin();    }
        }
		else{
			System.out.println("Please Enter Valid User Name");
		}
    
	}
	public void Options_Menu() {
		int Choice;
		System.out.println("===User Menu===");
		System.out.println("1.Update your Profile \n 2.Write Exam \n 3.Exit ");
		System.out.println("Enter your choice: ");
		Choice = obj.nextInt();
		switch(Choice) {
		case 1:
			ms=Update_Details();
			Options_Menu();
			break;
		case 2:
			Examination();
			Options_Menu();
			break;
		case 3:
            System.out.println("Thanks For Using!!!");
			System.exit(0);
			break;
		default:
			System.out.println("Please Enter Number in User Menu Only");
		}
	}
	public HashMap<String,Integer> Update_Details(){
		String update_name;
		int update_pwd;
		System.out.println("updateDetails Profile");
		System.out.println("Enter The Username: ");
		update_name = obj.next();
		if(ms.containsKey(update_name)) {
		System.out.println("Enter New Password for your Account");
		update_pwd = obj.nextInt();
		ms.replace(update_name, update_pwd);
        System.out.println("Updated Your Details Successfully....");
		}
		else {
			System.out.println("Please Enter The Correct UserName");
		}
		return ms;
	}
public void Examination() {
    Calendar cr = Calendar.getInstance();
	long StartTime=System.currentTimeMillis();
	long EndTime=StartTime+30;
	int AnsweredQueries=0;
	int UserAnswer,MarksSecured;
	System.out.println("Please Start Your Exam");
	System.out.println("These are the Examination Instructions: ");
	System.out.println("You Have To Answer 5 Questions in 30 Seconds");
	System.out.println("Each Question carries 10 marks and -5 for wrong answer");
	HashMap<String,ArrayList<String>> queries=new HashMap<String,ArrayList<String>>();
	
	ArrayList<String> Ques1=new ArrayList<String>();
    Ques1.add("O(n)");
	Ques1.add("O(1)");
	Ques1.add("O(logn)");
	Ques1.add("O(n-1)");
	Ques1.add("1");
	queries.put("State the search time complexity of an ordered array?",Ques1);
	ArrayList<String> Ques2=new ArrayList<String>();
	Ques2.add("Set");
	Ques2.add("HashMap");
	Ques2.add("List");
	Ques2.add("Collection");
	Ques2.add("1");
	queries.put(" HashSet internally uses?",Ques2);
	ArrayList<String> Ques3=new ArrayList<String>();
	Ques3.add("Generics");
	Ques3.add("Abstract classes");
	Ques3.add("Interfaces");
	Ques3.add("Collection");
	Ques3.add("1");
	queries.put("What guarantees type-safety in a collection?",Ques3);
	ArrayList<String> Ques4=new ArrayList<String>();
	Ques4.add("Treeset");
	Ques4.add("LinkedHashSet");
	Ques4.add("HashSet");
	Ques4.add("none");
	Ques4.add("1");
	queries.put("Which doesn't permit to store a null value?",Ques4);
    ArrayList<String> Ques5=new ArrayList<String>();
	Ques5.add("ArrayList");
	Ques5.add("LinkedList");
	Ques5.add("AbstractList");
	Ques5.add("none");
	Ques5.add("3");
	queries.put("Vector extends that of these?",Ques5);
	int sno=0;
    Set<String> set=queries.keySet(); 
    ArrayList<String> al=new ArrayList<>(set);
    int x=al.size();
	while(System.currentTimeMillis()<EndTime || sno<x) {
        String i=al.get(sno);
		System.out.println("\n\nQ."+(sno+1)+") "+i);
		System.out.println("\n(1) "+queries.get(i).get(0)+"\t"+"(2) "+queries.get(i).get(1)+"\t"+"(3) "+queries.get(i).get(2)+"\t"+"(4) "+queries.get(i).get(3)+" ");
		System.out.println("Enter Option");
		UserAnswer=obj.nextInt();
		System.out.println("Your Answers have been submitted successfully.....");
		if(UserAnswer==Integer.parseInt(queries.get(i).get(4))) {
			AnsweredQueries++;
		}
        sno++;
	}
	System.out.println("You Have Completed the Exam");
	MarksSecured=AnsweredQueries*10-((5-AnsweredQueries)*5); 
	System.out.println("Your score is..."+" "+MarksSecured+"/50");	
}

public static void main (String[] args)
{
	Exam em =new Exam ();
		em.Ulogin(); 
}
}