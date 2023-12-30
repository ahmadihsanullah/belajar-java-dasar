class User{
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }

    User(String username, String password){
        this.username = username;
        this.password = password;
    }

    protected void notification(String name){
        System.out.println("Halo user "+ name);
    }

}

class Admin extends User{
    String posisi;
    Admin(String username, String password, String posisi){
        super(username, password);
        this.posisi = posisi;
    }

    User CreateUser(String name, String password){
        User user = new User(name, password);
        return user;
    }

    @Override
    protected void notification(String name) {
        System.out.println("Halo admin "+ name);
    }

}


public class UserAndAdmin {
    public static void main(String[] args) {
        User user1 = new User("Ahmad", "rahasia");
        notif(user1);
        User user2 = new User("Hanif", "rahasia");
        notif(user2);
        Admin admin1 = new Admin("Admin", "rahasia","manager");
        notif(admin1);
        User user3 = admin1.CreateUser("jalu", "rahasia");
        notif(user3);
        notif(new Admin("aja", "aja","recruiter"));
    }

     static void notif(User user){
            if(user instanceof User){
                User person = (User) user;
                person.notification(user.getUsername());
            }else{
                Admin adminKantor = (Admin) user;
                adminKantor.notification( adminKantor.getUsername());

            }
        }
}
