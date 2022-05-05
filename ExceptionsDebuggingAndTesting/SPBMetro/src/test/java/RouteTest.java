import core.Line;
import core.Station;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RouteTest {
    Line line1 = new Line(1, "White");
    Line line2 = new Line(2, "Yellow");
    Line line3 = new Line(3, "Red");
    Station station0 = new Station("stA", line1);
    Station station1 = new Station("stB", line1);
    Station station2 = new Station("stC", line1);
    Station station3 = new Station("stD", line1);
    Station station4 = new Station("stE", line1);
    Station station5 = new Station("stF", line1);
    Station metro0 = new Station("metroA", line2);
    Station metro1 = new Station("metroB", line2);
    Station metro2 = new Station("metroC", line2);
    Station metro3 = new Station("metroD", line2);
    Station pyrone0 = new Station("pyroneA",line3);
    Station pyrone1 = new Station("pyroneB",line3);
    Station pyrone2 = new Station("pyroneC",line3);


    @Before
    public void setUp() {
        line1.addStation(station0);
        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line1.addStation(station4);
        line1.addStation(station5);
        line2.addStation(metro0);
        line2.addStation(metro1);
        line2.addStation(metro2);
        line2.addStation(metro3);
        line3.addStation(pyrone0);
        line3.addStation(pyrone1);
        line3.addStation(pyrone2);
    }

    @Test
    @DisplayName("Рассчет маршрута без пересадок")
    public void routeOnTheLine() {
        StationIndex index = new StationIndex();
        index.addLine(line1);
        RouteCalculator calc = new RouteCalculator(index);
        List<Station> actual = new ArrayList<>();
        actual.add(station0);
        actual.add(station1);
        actual.add(station2);
        actual.add(station3);
        actual.add(station4);
        Assertions.assertEquals(10.0, RouteCalculator.calculateDuration(calc.getShortestRoute(station0, station4)));
        Assertions.assertEquals(actual, calc.getShortestRoute(station0, station4));
    }

    @Test
    @DisplayName("Рассчет маршрута с 1 пересадкой")
    public void routeWithOneConnection() {
        List<Station> connectionStations = new ArrayList<>();
        connectionStations.add(station3);
        connectionStations.add(metro2);
        StationIndex index = new StationIndex();
        index.addLine(line1);
        index.addLine(line2);
        index.addStation(station0);
        index.addStation(station1);
        index.addStation(station2);
        index.addStation(station3);
        index.addStation(station4);
        index.addStation(station5);
        index.addStation(metro0);
        index.addStation(metro1);
        index.addStation(metro2);
        index.addStation(metro3);
        index.addConnection(connectionStations);
        RouteCalculator calc = new RouteCalculator(index);
        List<Station> actual = new ArrayList<>();
        actual.add(station0);
        actual.add(station1);
        actual.add(station2);
        actual.add(station3);
        actual.add(metro2);
        actual.add(metro1);
        actual.add(metro0);
        Assertions.assertEquals(16.0, RouteCalculator.calculateDuration(calc.getShortestRoute(station0, metro0)));
        Assertions.assertEquals(actual, calc.getShortestRoute(station0, metro0), "Кратчайший маршрут с пересадной не найден");
    }

    @Test
    @DisplayName("Маршрут с 2 персадками")
    public void routeWithTwoConnection() {
        List<Station> connectionStations = new ArrayList<>();
        List<Station> connectionStations2 = new ArrayList<>();
        connectionStations.add(station3);
        connectionStations.add(metro2);
        connectionStations2.add(metro0);
        connectionStations2.add(pyrone1);
        StationIndex index = new StationIndex();
        index.addLine(line1);
        index.addLine(line2);
        index.addLine(line3);
        index.addStation(station0);
        index.addStation(station1);
        index.addStation(station2);
        index.addStation(station3);
        index.addStation(station4);
        index.addStation(station5);
        index.addStation(metro0);
        index.addStation(metro1);
        index.addStation(metro2);
        index.addStation(metro3);
        index.addStation(pyrone0);
        index.addStation(pyrone1);
        index.addStation(pyrone2);
        index.addConnection(connectionStations);
        index.addConnection(connectionStations2);
        RouteCalculator calc = new RouteCalculator(index);
        List<Station> actual = new ArrayList<>();
        actual.add(station0);
        actual.add(station1);
        actual.add(station2);
        actual.add(station3);
        actual.add(metro2);
        actual.add(metro1);
        actual.add(metro0);
        actual.add(pyrone1);
        actual.add(pyrone0);
        Assertions.assertEquals(actual, calc.getShortestRoute(station0, pyrone0), "Кратчайший маршрут с 2 пересадками не найден");
    }
}
