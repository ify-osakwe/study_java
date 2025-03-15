package designPatterns.general.dependencyInjection;

interface Service {
    void write(String message);
}

class ServiceA implements Service {

    @Override
    public void write(String message) {
        System.out.println("Hello from ServiceA");
    }
}

class Client {
    private Service service;

    // injects via the constructor
    public Client(Service service) {
        this.service = service;
    }

    public void doSomething() {
        this.service.write("Hello from Client");
    }
}

public class DependencyInjection {
    public static void main(String[] args) {
        Service service = new ServiceA();
        Client client = new Client(service);
        client.doSomething();
    }
}
