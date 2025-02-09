package edu.au.cpsc.module4.data;

import edu.au.cpsc.module4.model.ScheduledFlight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements Serializable {

private List<ScheduledFlight> ScheduledFlights;

public AirlineDatabase(){

ScheduledFlights = new ArrayList<>();

}

public List<ScheduledFlight> getScheduledFlights() {

return ScheduledFlights;

}

public void addScheduledFlight(ScheduledFlight sf) {

if (sf == null) throw new IllegalArgumentException("Scheduled Flight cant be null");
ScheduledFlights.add(sf);
}
public void removeScheduledFlight(ScheduledFlight sf) {

if (sf == null) throw new IllegalArgumentException("Scheduled Flight cant be null");
ScheduledFlights.remove(sf);
}
public void updateScheduledFlight(ScheduledFlight sf) {

if (sf == null) throw new IllegalArgumentException("Scheduled Flight cant be null");
removeScheduledFlight(sf);
addScheduledFlight(sf);
}


}
