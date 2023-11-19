package entiter;

public class Subscriber extends User{
    public Subscriber(int id, String name, String sex) {
        super(id, name, sex);
    }
    public String toString() {
        return  "id :'" + getId() + '\'' +
                ",name:'" + getName() + '\'' +
                ", sex:'" + getSex() + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(sex, user.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }
}