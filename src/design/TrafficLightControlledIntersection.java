package design;
/*
 * https://leetcode.com/problems/traffic-light-controlled-intersection/
 * 
 * Traffic Light Controlled Intersection:
 * There is an intersection of two roads. First road is road A where cars travel from North to 
 * South in direction 1 and from South to North in direction 2. 
 * Second road is road B where cars travel from West to East in direction 3 and from 
 * East to West in direction 4.
 */
public class TrafficLightControlledIntersection {
	private int canPassRoad = 1;
	public TrafficLightControlledIntersection() {

	}

	public void carArrived(
			int carId,           // ID of the car
			int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
			int direction,       // Direction of the car
			Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
			Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
			) {
		synchronized (this) {
			if (canPassRoad != roadId) {
				canPassRoad = roadId;
				turnGreen.run();
			}
			crossCar.run();
		}
	}
}
