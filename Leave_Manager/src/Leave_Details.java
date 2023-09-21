//Store infos of employees to linked list
public class Leave_Details {

    String Name, Gender, Type;
    int Id;

    //Constructor
    public Leave_Details(String Name, int Id, String Gender, String Type) {
        this.Name = Name;
        this.Id = Id;
        this.Gender = Gender;
        this.Type = Type;

    }

    public Leave_Details() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "Name= " + Name + "\n"
                +"Id= " + Id + "\n"
                +"Gender= " + Gender + "\n"
                +"Type= " + Type + "\n";
    }

}
