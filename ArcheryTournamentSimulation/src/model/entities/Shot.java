package model.entities;

public class Shot {
	
	private double velocity;
	private double angle;
	private double distance;
	
	public Shot(double velocity, double angle) {
		this.velocity = velocity;
		this.angle = angle;
		this.distance = calculateDistance();
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public double calculateDistance() {
		double b = Math.toRadians(angle);
		this.distance = (Math.pow(velocity, 2)*Math.pow(Math.sin(b), 2))/(2*9.81);
		return distance;
	}
	
	public void incrementDistance(double increment) {
		double aux = this.distance * increment;
		this.distance = this.distance + aux; 
	}
	
	public void decrementDistance(double decrement) {
		double aux = this.distance*decrement;
		this.distance = this.distance - aux;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "velocity= " + velocity + ", angle=" + angle +" Distance: "+ distance;
	}

	public static void showArchery() {
		System.out.println("  O                           / |"+"                                    "+"  O                           / |");
		delay();
		System.out.println(" /_| >    .  .  .  .  .  >-->|  |"+"                                    "+" /_| >    .  .  .  .  .  >-->|  |");
		delay();
		System.out.println(" |||/                        |  |"+"                                    "+" |||/                        |  |");
		delay();
		System.out.println(" /|                          |__|"+"                                    "+" /|                          |__|");
		delay();
		System.out.println("/_|_____________________________|"+"                                    "+"/_|_____________________________|");
		delay();
	}
	
	public static void delay() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}	