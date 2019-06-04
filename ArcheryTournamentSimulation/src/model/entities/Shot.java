package model.entities;

public class Shot {
	
	private double velocity;
	private double angle;
	private double distance;
	
	public Shot(double velocity, double angle) {
		this.velocity = velocity;
		this.angle = angle;
		this.distance = calcualteDistance();
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
	
	public double calcualteDistance() {
		double b = Math.toRadians(angle);
		this.distance = (Math.pow(velocity, 2)*Math.pow(Math.sin(b), 2))/(2*9.81);
		return distance;
	}
	
	public void incrementDistance(double increment) {
		this.distance += (this.distance*increment); 
	}
	
	public void decrementDistance(double decrement) {
		this.distance -= (this.distance * decrement);
	}
	
	@Override
	public String toString() {
		return "velocity= " + velocity + ", angle=" + angle +" Distance: "+ distance;
	}

	public static void showArchery() {
		System.out.println("  O                           / |");
		System.out.println(" /_| >    .  .  .  .  .  >-->|  |");
		System.out.println(" |||/                        |  |");
		System.out.println(" /|                          |__|");
		System.out.println("/_|_____________________________|");
	}
}	