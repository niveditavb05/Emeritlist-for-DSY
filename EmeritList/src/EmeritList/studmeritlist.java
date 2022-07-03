/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmeritList;
import java.util.Formatter;
import java.util.Scanner;
/**
 *
 * @author NIVEDITA BIRAJDAR
 */


class Students
{       
    int Applicationid=0;
	String Name;
	String Category;
    int Maths,English,Science;
    double ssc,sscavg,diploma, Allavgmarks;
    int staterank,obcrank,scrank,openrank,ntrank;
	Students link;
	
	Students(int Applicationid,String Name,String Category,int Maths,int English,int Science,double ssc,double diploma)
	{			this.Name=Name;
                this.Category=Category;
                this.Maths=Maths;
                this.English=English;
                this.Science=Science;
                this.ssc=ssc;
                this.Applicationid=Applicationid;
                this.sscavg=((Maths+English+Science)/300)*100;
                this.diploma=diploma;
                this.staterank=0;
                this.obcrank=0;
                this.scrank=0;
                this.openrank=0;
                this.ntrank=0;
                link=null; 
	}
}
public class studmeritlist {
    Students head1=null;
	int ans;
	int nodecount=0;
	int front=-1,rear=-1,maxsize=0;
	
	Students[] studQueue;//used to store final merit list of students.
	Scanner sc=new Scanner (System.in);
			
			//method to calculate the no of total students dynamically.
			void CalculateMaxSize(studmeritlist obj) 
                        {
				obj.maxsize=0;
				Students ptr=obj.head1;
				while(ptr!=null){
					++obj.maxsize;
					ptr=ptr.link;
				}
				
			}
			
			//method to calculate Allavgmarks(used in case same diploma marks occur)
                        double StudentsRank(Students obj)
			{	
				obj.Allavgmarks=((obj.ssc+obj.sscavg))/200*100;
				return obj.Allavgmarks;
			}
			
			//method to sort the students according to their obtained marks.
			Students[] generatelist(studmeritlist obj) {
				Students ptr1=obj.head1;
				Students[] studarray=new Students[obj.maxsize];
				
				int k=0;
				
				while(ptr1!=null) {
					ptr1.Allavgmarks=StudentsRank(ptr1);
					studarray[k]=ptr1;
					++k;
					ptr1=ptr1.link;
				}
					
					Students[] temp=new Students[obj.maxsize];
					int staterank=0,obcrank=0,scrank=0,openrank=0,ntrank=0;
					
					
					if(studarray.length!=1) 
                                        {
					for(int i=0;i<studarray.length;i++)
					{ //bubble sort
						for(int j=0;j<studarray.length;j++) {
						//if same diploma marks	
						if(studarray[i].diploma==studarray[j].diploma) {
							if(studarray[i].Allavgmarks>studarray[j].Allavgmarks)
							{	
							temp[0]=studarray[i];
							studarray[i]=studarray[j];
							studarray[j]=temp[0];
						
							}
						}
						else {
							if(studarray[i].diploma>studarray[j].diploma) {
								temp[0]=studarray[i];
								studarray[i]=studarray[j];
								studarray[j]=temp[0];
							      }
						       }
					        }
						}	
					}
					//calculating respective ranks i=and storing in the object.
					for(int i=0;i<studarray.length;i++) {
						studarray[i].staterank=++staterank;
					if(studarray[i].Category.equals("OBC"))
						studarray[i].obcrank=++obcrank;
					else if(studarray[i].Category.equals("SC"))
						studarray[i].scrank=++scrank;
					else if(studarray[i].Category.equals("NT"))
						studarray[i].ntrank=++ntrank;
					else if(studarray[i].Category.equals("OPEN"))
						studarray[i].openrank=++openrank;
					else {}
					}
			
					return studarray;
			}
			
	     // method to check if the queue is empty
			boolean isEmpty(studmeritlist obj){
				if(obj.front == obj.rear +1  || ((obj.front == -1) && (obj.rear == -1))) 
					return true;
				else 
			
                                    return false; }
			
			// method to check if the queue is full
			boolean isFull(studmeritlist obj) {
				if ((obj.rear+1) % obj.maxsize == obj.front) 
					return true;
				else 
					return false;
						
				}
			//Creation of queue consist of students in order of their ranks
			void studQueue(studmeritlist obj){ 
				
				Students[] studarray=generatelist(obj);
				studQueue=new Students[obj.maxsize];
				int i=obj.maxsize;
					while(--i>=0) {
					if(isFull(obj)) {
						System.out.println("Sorry! can't process further");
					}
					else if(obj.front == -1 && obj.rear == -1){
						obj.front = obj.rear = 0;
						obj.studQueue[obj.rear]=studarray[obj.rear];
					}
					else {
						obj.rear = (obj.rear+1)%obj.maxsize;
						obj.studQueue[obj.rear]=studarray[obj.rear];
						}}
					if(!obj.isEmpty(obj))//checking if queue
						System.out.println("List generated successfully");
					else
						System.out.println("No data in the List");
				}
			
			//method to view details of student using application id
			void search(int applicationid,studmeritlist obj)
			{	try{ 	Students ptr=obj.head1;
					
			 	Formatter fmt = new Formatter();  
	        	fmt.format("%10s %15s %23s %15s %15s %15s %15s %15s \n", "Id", "Name", "Diploma marks","ssc marks","ssc Maths",
		        "ssc Science","ssc English","Category");   
	
			 	int i=0,status=0;
				        while (ptr != null) 
				        { 
				        	if(ptr.Applicationid==applicationid)
				        	{
				        	fmt.format("%2s %20s %15s %15s %15s %15s %15s %15s \n",ptr.Applicationid,ptr.Name,ptr.diploma,ptr.ssc,ptr.Maths
				        			,ptr.Science,ptr.English,ptr.Category);
				        	System.out.println(fmt);  
							++status; //to see that student found or not
					        }
				            ptr=ptr.link;
				        }
				        if(status==0)
				        	System.out.println("Sorry ,no student found!");   
			       }
			    catch(Exception e)
				   { System.out.println("Sorry ,no student found!");}
					
			}
			
			
			//method to display merit list.
			void displayQueue(studmeritlist obj){
				
				if(!obj.isEmpty(obj)) {
				System.out.println("_____________****Merit List****________________");
				Formatter fmt = new Formatter();  
				fmt.format("%2s %15s %23s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s\n", "Id", "Name", "Diploma marks","ssc marks","ssc Maths",
				"ssc Science","ssc English","Category","State level Rank","OPEN Rank"," OBC Rank","SC Rank","NT Rank");   
					 	
				for(int i =obj.front;i<=obj.rear;i++) {
					fmt.format("%2s %20s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s\n",obj.studQueue[i].Applicationid,obj.studQueue[i].Name,obj.studQueue[i].diploma,obj.studQueue[i].ssc,
							obj.studQueue[i].Maths,obj.studQueue[i].Science,obj.studQueue[i].English,obj.studQueue[i].Category,
							obj.studQueue[i].staterank,obj.studQueue[i].openrank,obj.studQueue[i].obcrank,obj.studQueue[i].scrank
							,obj.studQueue[i].ntrank);				
				}
				System.out.println(fmt);
				}
				else 
					System.out.println("\nMerit List has not been Generated yet.");
				
				
			}
			
			//method to create student node.
			void create(int Applicationid,String Name,String Category,
					int Maths,int English,int Science,double ssc,double diploma,studmeritlist obj) 
			{	Students studnode=new Students(Applicationid,Name,Category,Maths,English,Science,ssc,diploma); //assigning value using constructor
				 if(obj.head1==null)
				  {  obj.head1=studnode;   
				  		obj.nodecount++;
				  }
				 else
				 {   Students ptr=obj.head1;
				     while(ptr.link!=null)
				        ptr=ptr.link; 
				     
				     ptr.link=studnode;
				     obj.nodecount++;
				     
				 }
			     
				 CalculateMaxSize(obj);//calculates maxsize
			}
}