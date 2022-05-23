package project.JSon;

public class CustomerJson {
	int Id = -1;
    String Name = "None";
    String mail = "None";
    String Phone="None";
    String Location ="None";
    String Image="None";
    int Orders = 0;
   
    public CustomerJson() {
    }
    public int getId() {
        return Id;
    }
    

    public void setId(int id) {
        Id = id;
    }

    public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

  
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public int getOrders() {
        return Orders;
    }

    public void setOrders(int orders) {
        Orders = orders;
    }

  

}
