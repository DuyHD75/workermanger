
package entity;

/**
 *
 * @author This PC
 */
public class Worker {

    private int id;
    private String name, address, email;

    public Worker() {
    }

    public Worker(String name, String address, String email) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Worker(int id, String name, String address, String email) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + '}';
    }

}
