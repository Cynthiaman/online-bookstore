package task5;

public class UserInfo {
  private int id;
  private String name;
  private String password ;
  private String email;
  
  public UserInfo(){
	  //����һ�������������췽��
  }
  
  public int getId(){
	  return id;
  }
  public void setId(int id){
	  this.id=id;
  }
  
  public String getName(){
	  return name;
  }
  public void setName(String name){
	  this.name=name;
  } 
  
  public String getPassword(){
	  return password;
  }
  public void setPassword(String password){
	  this.password=password;
  }  
  
  public String getEmail(){
	  return email;
  }
  public void setEmail(String email){
	  this.email=email;
  }    
}
