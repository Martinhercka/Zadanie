package Hibernate;


import javax.persistence.*;

@Entity
@Table(name = "records")
public class Records
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    private String Name;

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }



    @Column(name = "tovar")
    private String Tovar;

    public String getTovar() {
        return Tovar;
    }
    public void setTovar(String tovar) {
        Tovar = tovar;
    }



    @Column(name = "pocet")
    private int Pocet;

    public int getPocet() {
        return Pocet;
    }
    public void setPocet(int pocet) {
        Pocet = pocet;
    }



    @Column(name = "krajina")
    private String krajina;

    public String getKrajina() {
        return krajina;
    }
    public void setKrajina(String krajina) {
        this.krajina = krajina;
    }












}
