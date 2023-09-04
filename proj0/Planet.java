public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
    }

    public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass =	p.mass;
		imgFileName = p.imgFileName;
    }

    // 创建 calcDistance 方法计算两个行星之间的距离
    public double calcDistance(Planet p){
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    // 创建 calcForceExertedBy 方法计算给定行星对该行星施加的力
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        return G * mass * p.mass / (r * r);
    }

    // 创建calcForceExertedByX 方法，计算给定行星对该行星在X方向施加的力
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dx / r;
    }


    // 创建calcForceExertedByY 方法，计算给定行星对该行星在X方向施加的力
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - yyPos;
        double r  = calcDistance(p);
        return calcForceExertedBy(p) * dy / r;
    }

    // 创建 calcNetForceExertedByX 方法，计算一个行星数组中所有行星对当前行星施加的x力
    public double calcNetForceExertedByX(Planet[] allPlanets) {
       double totalForce = 0;

       for(Planet planet : allPlanets) {
        if (this.equals(planet)) {
            continue;
        }
        totalForce += calcForceExertedByX(planet);
       }

        return totalForce;
    }



    // 创建 calcNetForceExertedByY 方法，计算一个行星数组中所有行星对当前行星施加的x力
     public double calcNetForceExertedByY(Planet[] allPlanets) {
       double totalForce = 0;

       for(Planet planet : allPlanets) {
        if (this.equals(planet)) {
            continue;
        }
        totalForce += calcForceExertedByY(planet);
       }

        return totalForce;
    }

    // 更新
    public void update(double dt,double fX,double fY){
		double ax = fX / mass;
		double ay = fY / mass;
		xxVel += dt * ax;
		yyVel += dt * ay;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}

    // 绘制
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}
