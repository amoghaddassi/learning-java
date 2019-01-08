public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/** Calculates the distance to P*/
	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double r2 = (dx * dx) + (dy * dy);
		return Math.sqrt(r2);
	}

	/** Calculates gravitational force exerted by P */
	public double calcForceExertedBy(Planet p) {
		double graviationalConstant = 6.67 * Math.pow(10, -11);
		double top = graviationalConstant * this.mass * p.mass;
		double bottom = calcDistance(p) * calcDistance(p);
		return top / bottom;
	}

	/** The x component of the gravitational force exerted by P */
	public double calcForceExertedByX(Planet p) {
		return (calcForceExertedBy(p) * (p.xxPos - this.xxPos)) / calcDistance(p);
	}

	/** The y component of the gravitational force exerted by P */
	public double calcForceExertedByY(Planet p) {
		return (calcForceExertedBy(p) * (p.yyPos - this.yyPos)) / calcDistance(p);
	}

	/** The net force in the x direction by all planets in Ps */
	public double calcNetForceExertedByX(Planet[] ps) {
		double net = 0;
		for (Planet p: ps) {
			if (this.equals(p)) {
				continue;
			}
			net = net + calcForceExertedByX(p);
		}
		return net;
	}

	/** The net force in the y direction by all planets in Ps */
	public double calcNetForceExertedByY(Planet[] ps) {
		double net = 0;
		for (Planet p: ps) {
			if (this.equals(p)) {
				continue;
			}
			net = net + calcForceExertedByY(p);
		}
		return net;
	}

	public void update(double dt, double fX, double fY) {
		// Acceleration due to the forces.
		double ax = fX / mass;
		double ay = fY / mass;
		//Updates velocity using the acceleration applied for the given time.
		xxVel = xxVel + dt * ax;
		yyVel = yyVel + dt * ay;
		//Updates position using the updated velocity.
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}
}







