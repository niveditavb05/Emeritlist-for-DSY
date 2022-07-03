/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmeritList;
import java.util.*;
/**
 *
 * @author NIVEDITA BIRAJDAR
 */

public class StudentEmeritList {
    public static void main(String[] args) {
	Scanner sc=new Scanner (System.in);
	studmeritlist obj=new studmeritlist(); //object
	
	
	int choice;
	String user,adminpassword="admin123";
	int applicationid=0;
        do{
	System.out.println("________________________________________________");
	System.out.println("\n*****Direct Second Year Admission*****\n");
	System.out.println("________________________________________________");
	System.out.println("Enter User Types : 1.Admin    2.Student ");
	System.out.println("Enter user type as 'none' to terminate the process:");
	
	
	
	System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
	System.out.println("\nEnter User Type Name :");
	user=sc.nextLine();
	if(user.equals("Admin")||user.equals("admin")) {
		String password;
		do {
		System.out.println("\nEnter Admin Password :");
		password=sc.nextLine();
		if(!password.equals(adminpassword))
				System.out.println("Incorrect password!! try again");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		
		}while(!password.equals(adminpassword));
		
		
		if(password.equals(adminpassword)) {
	do{
	System.out.println("\n_____________****Welcome to Admin Panel****________________");
	System.out.println("\n Menu For Admin: \n 1.Generate Merit List\n 2.Display Merit List \n 3.Search Student \n");
	System.out.println("\nEnter 0 to exit the Admin mode .\n");
	System.out.println("________________________________________________");
	
			
		System.out.println("Enter your choice....");
		choice =Integer.parseInt(sc.nextLine());
		
		switch(choice){
		
		  		case 1: obj.studQueue(obj);
		  				System.out.println("________________________________________________");
		  				break;
	  		 
		        case 2: obj.displayQueue(obj);
		        		System.out.println("________________________________________________");
		        		break;
		            
		        case 3: System.out.println("\n_ _ _ _ _ _ _ _ _****View Details****_ _ _ _ _ _ _");
		        		System.out.println("\nEnter Application Id :"); 
						int id=Integer.parseInt(sc.nextLine());
						obj.search(id,obj);
						System.out.println("________________________________________________");
						break;
			 default:if(choice!=0)
				 	 {	System.out.println("Invalid choice!!Please enter valid choice \n");
			 			System.out.println("________________________________________________");
				 		}
			 		 break;
		        }
		}while(choice!=0);
		System.out.println("\n                  ****Thank You !!****");
	    }
	}

	else if(user.equals("Student")||user.equals("student")) {
            do{
		System.out.println("\n_____________****Welcome to Student Panel****________________");
		System.out.println("\n Menu For Student: \n 1.Register Application Form \n 2.Display Merit List \n 3.View details(Search by appication id)");
		System.out.println("\nEnter 0 to exit the Student mode .\n");
		System.out.println("________________________________________________");	
		
	
		
		System.out.println("Enter your choice....");
		choice =Integer.parseInt(sc.nextLine());
	
		switch(choice){
	
		        case 1: System.out.println("\nEnter your name :");
						String Name=sc.nextLine();
						
						int Applicationid=++applicationid;
						
						System.out.println("Enter your category(OBC/OPEN/SC/NT) :");
						String Category=sc.nextLine();
						
						System.out.println("Enter your maths:");
						int Maths=Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter your eng:");
						int English=Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter your science:");
						int Science=Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter your ssc:");
						double ssc=Double.parseDouble(sc.nextLine());
						 
						System.out.println("Enter your diploma:");
						double diploma=Double.parseDouble(sc.nextLine());
						 
						obj.create(Applicationid,Name, Category,
						Maths,English,Science,ssc, diploma,obj) ;
						 
						System.out.println("\nSuccessfully Registered !!\nYour Application id :"+applicationid+"\n");
						System.out.println("________________________________________________");
						break;
					
		        case 2:obj.displayQueue(obj);
		        	   System.out.println("________________________________________________");
		               break;
		            
		        case 3:System.out.println("\n_ _ _ _ _ _ _ _ _****View Details****_ _ _ _ _ _ _");
		        	   System.out.println("\nEnter your Application Id:");
					   int id=Integer.parseInt(sc.nextLine());
					   obj.search(id,obj);
					   System.out.println("________________________________________________");
					   break;
			 default:if(choice!=0)
				 	 	{System.out.println("Invalid choice!!Please enter valid choice");
			 			System.out.println("\n________________________________________________");
				 		}
			 		 break;
	        }
		}while(choice!=0);
		System.out.println("\n                  ****Thank You !!****");}
		else
			if(!user.equals("none"))
			System.out.println("Enter valid User type name..try again");
	}while(!user.equals("none"));
	 System.out.println("\n                  ****Thank You !!****");
  }
}
