public class NBody {
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		in.readInt();
		return in.readDouble();
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		int numPlanets = in.readInt();
		Planet[] planets = new Planet[numPlanets];
		in.readDouble();
		
		for (int i = 0; i<numPlanets; i++) {
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, img);
		}
		return planets;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		// Draws the universe
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (Planet p: planets) {
			p.draw();
		}

		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time<T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			//Calculates the forces on all the planets in the system
			for (int i =0; i< planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			//Updates the velocity and position of planets due to forces
			for (int i = 0; i<planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			//Draws the planets in their updated positions
			StdDraw.picture(0,0,"images/starfield.jpg");
			for (Planet p:planets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;	
		}
	}
}