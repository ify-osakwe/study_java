package designPatterns.structural.facade;

/**
 * <p> Examples of facade pattern - JDBC; creates a connection using java.sql.Connection, the
 * implementation of which we are not concerned about.
 *
 * <p> NOTE - an adapter changes an interface int one a client expects. A facade decouples
 * client from a complex subsystem. An adapter wraps an object to change its interface. A decorator
 * wraps an object to add new behaviours and responsibilities. A facade "wraps" a set of objects
 * to simplify.
 */
public class FacadePattern {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier("Top-O-Line Amplifier");
        Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
        DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
        CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
        Projector projector = new Projector("Top-O-Line Projector", dvd);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd,
                projector, screen, lights, popper);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
