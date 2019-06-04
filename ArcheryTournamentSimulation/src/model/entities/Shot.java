package model.entities;

public class Shot {
	
	private double velocity;
	private double angle;
	
	public Shot(double velocity, double angle) {
		this.velocity = velocity;
		this.angle = angle;
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
		double distance = (Math.pow(velocity, 2)*Math.pow(Math.sin(b), 2))/(2*9.81);
		return distance;
	}
	
	public double incrementDistance(double increment) {
		return calcualteDistance() + (calcualteDistance()*increment); 
	}
	
	@Override
	public String toString() {
		return "Shot [velocity=" + velocity + ", angle=" + angle + "]";
	}

	public static void showArchery() {
		System.out.println("  O                           / |");
		System.out.println(" /_| >    .  .  .  .  .  >-->|  |");
		System.out.println(" |||/                        |  |");
		System.out.println(" /|                          |__|");
		System.out.println("/_|_____________________________|");
	}
}	