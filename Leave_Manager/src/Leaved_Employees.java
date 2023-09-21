//Stack
public class Leaved_Employees {

    String Name, Gender, Type;
    int Id;

    public Leaved_Employees(String Name, int Id, String Gender, String Type) {
        this.Name = Name;
        this.Id = Id;
        this.Gender = Gender;
        this.Type = Type;
    }

    public Leaved_Employees() {

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
