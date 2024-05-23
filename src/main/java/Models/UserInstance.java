package Models;

public class UserInstance {
    private int user_id;



    public UserInstance(){

    }

    public UserInstance(int user_id) {
        this.user_id = user_id;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private static UserInstance instance = null;
    public static UserInstance getInstance() {
        if (instance == null) {
            instance = new UserInstance();
        }
        return instance;
    }
}
