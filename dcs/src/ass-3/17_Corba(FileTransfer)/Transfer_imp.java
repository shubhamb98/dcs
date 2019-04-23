import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import org.omg.CORBA.ORB;
import TransferApp.TransferPOA;
public class Transfer_imp  extends TransferPOA{
    private ORB orb;
    public void setORB(ORB orb_val){
                orb=orb_val;
    }
	@Override
	public String transfer(String file1)  
	{
		String f="";
		if(file1.equals("dept"))
		{
			f="//home//hyperx//Desktop//FILES//a.txt";
		}
		else if(file1.equals("student"))
		{
			f="//home//hyperx//Desktop//FILES//b.txt";
		}
		else if(file1.equals("Teacher"))
		{
			f="//home//hyperx//Desktop//FILES//c.txt";
		}
		String s1 = "";
		int i;
		FileInputStream fi;
		try {
			fi = new FileInputStream(f);
		  	do{
                     		i = fi.read(); //Read the file contents
                     		if(i!= -1)
                    			s1= s1+((char)i);
          		} while(i != -1);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	@Override
	public void shutdown(){
		 orb.shutdown(false);
	}
	@Override
	public boolean fileCreate(String file1) 
	{
		String f="//home//hyperx//Desktop//RECEIVED//";
		String re[]=file1.split("//",6);
		System.out.println(re[re.length-1]);
		f=f+re[re.length-1];
		System.out.println(f);
		File sco=new File(file1);
		File des=new File(f);
//		File file = new File(f);
//            boolean fvar;
//			try {
//				fvar = file.createNewFile();
//			
//	     if (fvar){
//	          System.out.println("File has been created successfully");
//	          return true;
//	     }
//	     else{
//	          System.out.println("File already present at the specified location");
//	          return false;
//	     }	
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return false;
		try{
			Files.copy(sco.toPath(), des.toPath());
			return true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
