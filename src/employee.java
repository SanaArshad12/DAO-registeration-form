public class employee {
    int NoofTickets = 0;
    int id;
    String name;

    public employee(int noofTickets, int id, String name) {
        NoofTickets = noofTickets;
        this.id = id;
        this.name = name;
    }


//    public employee(String name, int id) {
//        this.name = name;
//        this.id = id;
//    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public int getNoofTickets() {
        return NoofTickets;
    }

    public void setNoofTickets(int noofTickets) {
        NoofTickets = noofTickets;
    }
}