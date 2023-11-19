package entiter;

public class Author extends User{
    public Authoruthor(int id, String name, String sex) {
        super(id, name, sex);
    }
    public String toString() {
        return  "id :'" + getId() + '\'' +
                ",name:'" + getName() + '\'' +
                ", sex:'" + getSex() + '\'';
    }

}