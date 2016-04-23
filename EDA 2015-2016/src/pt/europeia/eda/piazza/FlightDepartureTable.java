package pt.europeia.eda.piazza;

import static java.lang.System.out;

import pt.europeia.eda.book.chapter3.section2.BstOrderedTable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDepartureTable {

    private BstOrderedTable<LocalDateTime, List<String>> flightDepartures;

    public FlightDepartureTable() {
        flightDepartures = new BstOrderedTable<>();
    }

    public Iterable<String> destinationsFor(final LocalDateTime departureTime) {
        if (!flightDepartures.contains(departureTime))
            return new ArrayList<>();

        return new ArrayList<>(flightDepartures.valueFor(departureTime));
    }

    public Iterable<LocalDateTime> departureTimes() {
        return flightDepartures.keys();
    }

    public void print() {
        for (LocalDateTime departureTime : departureTimes())
            out.println(departureTime + "\t" + destinationsFor(departureTime));
    }

    public void addFlight(final LocalDateTime departureTime,
            final String destination) {
        if (!flightDepartures.contains(departureTime))
            flightDepartures.put(departureTime, new ArrayList<>());

        flightDepartures.valueFor(departureTime).add(destination);
    }

    public void removeFlightsBefore(final LocalDateTime departureTimeLimit) {
        for (LocalDateTime departureTime : departureTimes())
            if (departureTime.compareTo(departureTimeLimit) < 0)
                flightDepartures.delete(departureTime);
    }

    public static void main(final String[] arguments) {
        final FlightDepartureTable departures = new FlightDepartureTable();

        // Add a few flights:
        departures.addFlight(LocalDateTime.of(2016, 4, 23, 12, 05), "Madrid");
        departures.addFlight(LocalDateTime.of(2016, 4, 23, 12, 05), "Paris");
        departures.addFlight(LocalDateTime.of(2016, 4, 23, 12, 15), "Munich");
        departures.addFlight(LocalDateTime.of(2016, 4, 23, 12, 15), "London");
        departures.addFlight(LocalDateTime.of(2016, 4, 23, 12, 15), "Oslo");

        // All flights printed as a table of times with a series of destinations
        // for each time:
        out.println("Scheduled departures:");
        departures.print();

        // No destinations for now:
        out.print("Scheduled destinations for flights departing now: ");
        out.println(departures.destinationsFor(LocalDateTime.now()));

        // Remove all flights before 2016-4-23T12:10:
        out.println("Removing all departures before 2016-4-23 12:10…");
        departures.removeFlightsBefore(LocalDateTime.of(2016, 4, 23, 12, 10));

        // All remaining flights printed as a table of times with a series of
        // destinations for each time:
        out.println("Scheduled departures:");
        departures.print();
    }

}
