public class Admin extends Person{

    private String user_name;
    private String password;
    private static Admin admin = new Admin("admin","admin35");

    private Admin(String user_name, String password)
    {
        super(password);
        this.user_name = user_name;
    }
    public static Admin getAdmin()
    {
    	return admin;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

  
}
