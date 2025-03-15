package designPatterns.general.dependencyInversion;

interface DBConnection {
    int connect();
}

class MySqlConnection implements DBConnection {

    @Override
    public int connect() {
        return 1;
    }
}

class PasswordReminder {
    private DBConnection dbConnection;

    public  PasswordReminder(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
}


public class DependencyInversion {
    public static void main(String[] args) {

    }
}
